package com.vladyka.dto.purchase;

import com.vladyka.enums.Currency;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PurchaseDto {
    private String date;
    private double price;
    private Currency currency;
    private String productName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}