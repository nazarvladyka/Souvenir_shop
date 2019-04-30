package com.vladyka.souvenir_shop.api.domain;

import com.vladyka.souvenir_shop.api.enums.Currency;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="date")
    private Date date;

    @Column(name="price")
    private Double price;

    @Column(name="currency")
    private Currency currency;

    @Column(name="product_name")
    private String productName;

    public Purchase() {
    }

    public Purchase(Date date, Double price, Currency currency, String productName) {
        this.date = date;
        this.price = price;
        this.currency = currency;
        this.productName = productName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return productName + " " +
                price + " " +
                currency;
    }
}