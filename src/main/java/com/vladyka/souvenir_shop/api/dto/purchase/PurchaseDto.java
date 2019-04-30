package com.vladyka.souvenir_shop.api.dto.purchase;

import com.vladyka.souvenir_shop.api.enums.Currency;

public class PurchaseDto {
    private String date;
    private Double price;
    private Currency currency;
    private String productName;

    public PurchaseDto() {
    }

    public PurchaseDto(String date, Double price, Currency currency, String productName) {
        this.date = date;
        this.price = price;
        this.currency = currency;
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}