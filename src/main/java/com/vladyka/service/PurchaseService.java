package com.vladyka.service;

import com.vladyka.domain.Purchase;
import com.vladyka.dto.purchase.DailyReport;
import com.vladyka.dto.purchase.PurchaseDto;
import com.vladyka.dto.purchase.PurchaseDtoWODate;
import com.vladyka.dto.purchase.PurchasesReport;
import com.vladyka.enums.Currency;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public interface PurchaseService {

    com.vladyka.domain.Purchase save(Purchase purchase);

    Iterable<com.vladyka.domain.Purchase> all();

    Iterable<com.vladyka.domain.Purchase> all (int year);

    Iterable<com.vladyka.domain.Purchase> all (Date date);

    Iterable<com.vladyka.domain.Purchase> getPurchasesByDate(Date date);

    int clear(String date) throws ParseException;

    double report(int year, Currency currency);

    PurchasesReport getPurchasesReport() throws ParseException;

    DailyReport getDailyReport(String date) throws ParseException;

    PurchaseDtoWODate getPurchaseDtoWithoutDate(Purchase purchase);

    Set<Date> getPurchasesDates();

    void savePurchase(PurchaseDto purchaseDto) throws ParseException;
}