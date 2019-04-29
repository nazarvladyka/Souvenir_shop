package com.vladyka.service;

import com.vladyka.domain.Purchase;
import com.vladyka.dto.DailyReport;
import com.vladyka.dto.PurchaseDto;
import com.vladyka.dto.PurchaseDtoWODate;
import com.vladyka.dto.PurchasesReport;
import com.vladyka.enums.Currency;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public interface PurchaseService {

    com.vladyka.domain.Purchase save(com.vladyka.domain.Purchase purchase);

    Iterable<com.vladyka.domain.Purchase> all();

    Iterable<com.vladyka.domain.Purchase> all (int year);

    Iterable<com.vladyka.domain.Purchase> all (Date date);

    Iterable<com.vladyka.domain.Purchase> getPurchasesByDate(Date date);

    boolean clear(Date date);

    double report(int year, Currency currency);

    PurchasesReport getPurchasesReport() throws ParseException;

    DailyReport getDailyReport(String date) throws ParseException;

    PurchaseDtoWODate getPurchaseDtoWithoutDate(Purchase purchase);

    Set<Date> getPurchasesDates();

    void savePurchaseDto(PurchaseDto purchaseDto) throws ParseException;
}