package com.vladyka.souvenir_shop.api.repository;

import com.vladyka.souvenir_shop.api.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    Iterable<Purchase> findAllByDate(Date date);

    Iterable<Purchase> findAllByOrderByDate();

    Iterable<Purchase> findAllByDateBetween(Date start, Date stop);

    Iterable<Purchase> findAll();

    Integer deleteAllByDate(Date date);
}