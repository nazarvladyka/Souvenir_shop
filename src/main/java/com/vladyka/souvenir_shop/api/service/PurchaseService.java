package com.vladyka.souvenir_shop.api.service;

import com.vladyka.souvenir_shop.api.domain.Purchase;
import com.vladyka.souvenir_shop.api.dto.purchase.DailyPurchases;
import com.vladyka.souvenir_shop.api.dto.purchase.PurchaseDto;
import com.vladyka.souvenir_shop.api.dto.purchase.AllPurchases;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface PurchaseService {
    void savePurchase(PurchaseDto purchaseDto) throws ParseException;

    void saveAll(List<Purchase> purchases);

    AllPurchases getAllPurchases();

    DailyPurchases getDailyPurchases(Date date);

    List<Purchase> getAllPurchasesByYear(int year);

    int clear(String date) throws ParseException;
}