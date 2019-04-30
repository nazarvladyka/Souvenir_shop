package com.vladyka.service.impl;

import com.google.common.collect.Lists;
import com.vladyka.domain.Purchase;
import com.vladyka.dto.ReportRequest;
import com.vladyka.dto.ReportResponse;
import com.vladyka.dto.rate.ExchangeRate;
import com.vladyka.dto.rate.Rates;
import com.vladyka.enums.Currency;
//import com.vladyka.repository.ExchangeRateRepository;
import com.vladyka.repository.PurchaseRepository;
import com.vladyka.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    private RestTemplate restTemplate = new RestTemplate();
    private ExchangeRate exchangeRate;

    @Override
    public double getExchangeRate(Currency currency) {
        Rates rates = exchangeRate.getRates();
        if (currency == Currency.USD) {
            return rates.getUSD();
        } else if (currency == Currency.UAH) {
            return rates.getUAH();
        } else if (currency == Currency.PLN) {
            return rates.getPLN();
        } else return rates.getUAH();
    }

    @Override
    public ReportResponse getReport(ReportRequest reportRequest) throws ParseException {
        ReportResponse reportResponse = new ReportResponse();

        String access_key = "745a0b42b25b1d3fc36e47db388d31a1";
        exchangeRate = restTemplate.getForObject("http://data.fixer.io/api/latest?access_key=" + access_key + "&symbols=USD,UAH,PLN", ExchangeRate.class);
//        getAllCurrency(reportRequest.getYear());

        String currency = reportRequest.getCurrency();
        double sum = getAmount(Currency.valueOf(currency), reportRequest.getYear());

        reportResponse.setSum(sum);
        reportResponse.setCurrency(currency);

        return reportResponse;
    }

    private Set<Currency> getAllCurrency(int year) throws ParseException {
        List<Purchase> purchases = getAllPurchasesByYear(year);
        Set<Currency> currencies = new HashSet<>();

        System.out.println(purchases);
        return currencies;
    }

    private List<Purchase> getAllPurchasesByYear(int year) throws ParseException {
        List<Purchase> purchases;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date start = simpleDateFormat.parse(year + "-01-01");
        Date stop = simpleDateFormat.parse(year + "-12-31");

        purchases = Lists.newArrayList(purchaseRepository.findAllByDateBetween(start, stop));

//        String dateS = year + "-01-01";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse(dateS);
//
//        purchases = Lists.newArrayList(purchaseRepository.findAllByDate_Year(date));

        return purchases;
    }

    private double getAmount(Currency currency, int year) throws ParseException {
        List<Purchase> purchases = getAllPurchasesByYear(year);

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
}