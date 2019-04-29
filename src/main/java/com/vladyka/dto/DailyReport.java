package com.vladyka.dto;

import java.util.List;

public class DailyReport {
    private String date;
    private List<PurchaseDtoWODate> purchases;

    public DailyReport() {
    }

    public DailyReport(String date, List<PurchaseDtoWODate> purchaseDtoWODates) {
        this.date = date;
        this.purchases = purchaseDtoWODates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PurchaseDtoWODate> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseDtoWODate> purchaseDtoWODates) {
        this.purchases = purchaseDtoWODates;
    }
}
