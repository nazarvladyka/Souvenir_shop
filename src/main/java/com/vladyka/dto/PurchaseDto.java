package com.vladyka.dto;

import com.vladyka.enums.Currency;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="date")
    private String date;

    @Column(name="price")
    private double price;

    @Column(name="currency")
    private Currency currency;

    @Column(name="product_name")
    private String productName;
}