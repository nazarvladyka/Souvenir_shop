package com.vladyka.domain;

import com.vladyka.enums.Currency;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @Override
    public String toString() {
        return "Purchase{" +
                "date=" + date +
                ", price=" + price +
                ", currency=" + currency +
                ", productName='" + productName + '\'' +
                '}';
    }
}