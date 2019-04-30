package com.vladyka.souvenir_shop.api.dto.purchase;

import java.util.List;

public class DailyPurchases {
    private String date;
    private List<PurchaseWODate> purchases;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PurchaseWODate> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseWODate> purchaseWODates) {
        this.purchases = purchaseWODates;
    }
}