package com.vladyka.repository;

import com.vladyka.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    Iterable<Purchase> findAllByDate(Date date);

    Integer deleteAllByDate(Date date);

    Iterable<Purchase> findAll();

    Iterable<Purchase> findAllByOrderByDate();
}