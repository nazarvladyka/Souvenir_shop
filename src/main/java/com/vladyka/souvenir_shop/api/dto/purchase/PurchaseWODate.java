package com.vladyka.souvenir_shop.api.dto.purchase;

import com.vladyka.souvenir_shop.api.enums.Currency;

public class PurchaseWODate {
    private String productName;
    private Double price;
    private Currency currency;

    public PurchaseWODate() {
    }

    public PurchaseWODate(String productName, Double price, Currency currency) {
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