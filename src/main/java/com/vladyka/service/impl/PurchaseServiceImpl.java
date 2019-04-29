package com.vladyka.service.impl;

import com.vladyka.domain.Purchase;
import com.vladyka.enums.Currency;
import com.vladyka.repository.PurchaseRepository;
import com.vladyka.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public Iterable<Purchase> allByYear(int year) {
        Date date = new Date(01/01/year);
        return purchaseRepository.findAllByDate(date);
    }

    @Override
    public Iterable<Purchase> getPurchasesByDate(Date date) {
        return purchaseRepository.findAllByDate(date);
    }

    @Override
    public boolean clear(Date date) {
        return purchaseRepository.deleteAllByDate(date);
    }

    @Override
    public double report(int year, Currency currency) {
        Iterable<Purchase> purchases = allByYear(year);
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
}