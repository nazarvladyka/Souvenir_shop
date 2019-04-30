package com.vladyka.repository;

import com.vladyka.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.time.Year;
import java.util.Date;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    Iterable<Purchase> findAllByDate(Date date);

    Integer deleteAllByDate(Date date);

    Iterable<Purchase> findAll();

    Iterable<Purchase> findAllByOrderByDate();

//    Iterable<Purchase> findAllByDate_Year(Date date);

    Iterable<Purchase> findAllByDateBetween(Date start, Date stop);
}