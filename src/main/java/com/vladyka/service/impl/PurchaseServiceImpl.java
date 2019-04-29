package com.vladyka.service.impl;

import com.google.common.collect.Lists;
import com.vladyka.domain.Purchase;
import com.vladyka.dto.DailyReport;
import com.vladyka.dto.PurchaseDto;
import com.vladyka.dto.PurchaseDtoWODate;
import com.vladyka.dto.PurchasesReport;
import com.vladyka.enums.Currency;
import com.vladyka.repository.PurchaseRepository;
import com.vladyka.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    private CurrencyServiceImpl currencyService;

    static int id = 0;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase save(Purchase purchase) {
        id++;
        return purchaseRepository.save(purchase);
    }

    @Override
    public Iterable<Purchase> all() {
        return purchaseRepository.findAll();
    }

    @Override
    public Iterable<Purchase> all(Date date) {
        return purchaseRepository.findAllByDate(date);
    }

    @Override
    public Iterable<Purchase> all(int year) {
        Date date = new Date(01/01/year);
        return purchaseRepository.findAllByDate(date);
    }

    @Override
    public Iterable<Purchase> getPurchasesByDate(Date date) {
        return purchaseRepository.findAllByDate(date);
    }

    @Transactional
    @Override
    public int clear(String dateS) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateS);

        return purchaseRepository.deleteAllByDate(date);
    }

    @Override
    public double report(int year, Currency currency) {
        Iterable<Purchase> purchases = all(year);
        double amountInEUR = 0;
        double amount;

        for(Purchase purchase: purchases) {
            //convert all currency to EUR
            if(purchase.getCurrency() != Currency.EUR) {
                double exchangeRate = currencyService.getExchangeRate(purchase.getCurrency());
                amountInEUR += purchase.getPrice() * exchangeRate;
            } else {
                amountInEUR += purchase.getPrice();
            }
        }

        if(currency == Currency.EUR) {
            amount = amountInEUR;
        } else {
            amount = amountInEUR * currencyService.getExchangeRate(currency);
        }

        return amount;
    }

    @Override
    public PurchasesReport getPurchasesReport() throws ParseException {
        PurchasesReport purchasesReport = new PurchasesReport();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Set<Date> dates = getPurchasesDates();
        Set<String> datesS = new HashSet<>();
        List<DailyReport> dailyReports = new ArrayList<>();

        for (Date date : dates) {
            datesS.add(simpleDateFormat.format(date));
        }

        for(String d : datesS) {
            dailyReports.add(getDailyReport(d));
        }

        purchasesReport.setDailyReports(dailyReports);

        return purchasesReport;
    }

    @Override
    public DailyReport getDailyReport(String date) throws ParseException {
        DailyReport dailyReport = new DailyReport();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date1 = simpleDateFormat.parse(date);


        List<PurchaseDtoWODate> purchasesDtoWODate = new ArrayList<>();
        List<Purchase> purchases =  Lists.newArrayList(purchaseRepository.findAllByDate(date1));

        for(Purchase p : purchases) {
            purchasesDtoWODate.add(getPurchaseDtoWithoutDate(p));
        }

        dailyReport.setDate(date);
        dailyReport.setPurchases(purchasesDtoWODate);

        return dailyReport;
    }

    @Override
    public PurchaseDtoWODate getPurchaseDtoWithoutDate(Purchase purchase) {
        PurchaseDtoWODate purchaseDtoWODate = new PurchaseDtoWODate();

        purchaseDtoWODate.setProductName(purchase.getProductName());
        purchaseDtoWODate.setPrice(purchase.getPrice());
        purchaseDtoWODate.setCurrency(purchase.getCurrency());

        return purchaseDtoWODate;
    }

    @Override
    public Set<Date> getPurchasesDates() {
        Set<Date> dates = new HashSet<>();
        Iterable<Purchase> purchases = purchaseRepository.findAllByOrderByDate();

        for(Purchase p : purchases) {
            dates.add(p.getDate());
        }

        return dates;
    }

    @Override
    public void savePurchase(PurchaseDto purchaseDto) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(purchaseDto.getDate());

        Purchase purchase = new Purchase(date, purchaseDto.getPrice(),
                purchaseDto.getCurrency(), purchaseDto.getProductName());

        save(purchase);
    }
}