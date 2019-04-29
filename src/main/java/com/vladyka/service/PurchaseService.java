package com.vladyka.service;

import com.vladyka.domain.Purchase;
import com.vladyka.enums.Currency;

import java.util.Date;

public interface PurchaseService {

    Purchase save(Purchase purchase);

    Iterable<Purchase> all();

    Iterable<Purchase> allByYear(int year);

    Iterable<Purchase> getPurchasesByDate(Date date);

    boolean clear(Date date);

    double report(int year, Currency currency);
}