package com.vladyka.dto;

import java.util.List;

public class DailyReport {
    private String date;
    private List<PurchaseDtoWODate> purchasesDtoWODates;

    public DailyReport() {
    }

    public DailyReport(String date, List<PurchaseDtoWODate> purchaseDtoWODates) {
        this.date = date;
        this.purchasesDtoWODates = purchaseDtoWODates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PurchaseDtoWODate> getPurchasesDtoWODates() {
        return purchasesDtoWODates;
    }

    public void setPurchasesDtoWODates(List<PurchaseDtoWODate> purchaseDtoWODates) {
        this.purchasesDtoWODates = purchaseDtoWODates;
    }
}
