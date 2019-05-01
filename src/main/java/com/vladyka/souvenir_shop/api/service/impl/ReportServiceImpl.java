package com.vladyka.souvenir_shop.api.service.impl;

import com.vladyka.souvenir_shop.api.domain.Purchase;
import com.vladyka.souvenir_shop.api.dto.rate.ExchangeRate;
import com.vladyka.souvenir_shop.api.dto.rate.Rates;
import com.vladyka.souvenir_shop.api.dto.report.ReportRequest;
import com.vladyka.souvenir_shop.api.dto.report.ReportResponse;
import com.vladyka.souvenir_shop.api.enums.Currency;
import com.vladyka.souvenir_shop.api.service.ReportService;
import com.vladyka.souvenir_shop.api.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Value("${fixer.io.url}")
    private String url;
    private String accessKey = System.getenv("accessKey");

    private RestTemplate restTemplate = new RestTemplate();
    private ExchangeRate exchangeRate;
    private final PurchaseService purchaseService;

    @Autowired
    public ReportServiceImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public ReportResponse getReport(ReportRequest reportRequest) {
        ReportResponse reportResponse = new ReportResponse();

        exchangeRate = restTemplate.getForObject(url + accessKey + "&symbols=USD,UAH,PLN", ExchangeRate.class);

        String currency = reportRequest.getCurrency();
        double sum = getAmount(Currency.valueOf(currency), reportRequest.getYear());

        reportResponse.setSum(sum);
        reportResponse.setCurrency(currency);

        return reportResponse;
    }

    private double getAmount(Currency currency, int year) {
        List<Purchase> purchases = purchaseService.getAllPurchasesByYear(year);

        double amountInEUR = 0;
        double amount;

        //convert all currency to EUR
        for (Purchase purchase : purchases) {
            if (purchase.getCurrency() != Currency.EUR) {
                double exchangeRate = getExchangeRate(purchase.getCurrency());
                amountInEUR += purchase.getPrice() / exchangeRate;
            } else {
                amountInEUR += purchase.getPrice();
            }
        }

        if (currency == Currency.EUR) {
            amount = amountInEUR;
        } else {
            amount = amountInEUR * getExchangeRate(currency);
        }

        return amount;
    }

    private double getExchangeRate(Currency currency) {
        Rates rates = exchangeRate.getRates();

        switch (currency) {
            case USD:
                return rates.getUSD();
            case UAH:
                return rates.getUAH();
            case PLN:
                return rates.getPLN();
            default:
                return rates.getUAH();
        }
    }
}