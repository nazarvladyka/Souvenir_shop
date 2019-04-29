package com.vladyka.dto;

import com.vladyka.enums.Currency;

public class PurchaseDtoWODate {
    private String productName;
    private double price;
    private Currency currency;

    public PurchaseDtoWODate() {
    }

    public PurchaseDtoWODate(String productName, double price, Currency currency) {
        this.productName = productName;
        this.price = price;
        this.currency = currency;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
