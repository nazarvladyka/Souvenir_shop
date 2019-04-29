package com.vladyka.domain;

import com.vladyka.enums.Currency;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="date")
    private Date date;

    @Column(name="price")
    private double price;

    @Column(name="currency")
    private Currency currency;

    @Column(name="product_name")
    private String productName;

    public Purchase() {
    }

    public Purchase(Date date, double price, Currency currency, String productName) {
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

    @Override
    public String toString() {
        return productName + " " +
                price + " " +
                currency;
    }
}