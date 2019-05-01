package com.vladyka.souvenir_shop.api.controller;

import com.vladyka.souvenir_shop.api.domain.Purchase;
import com.vladyka.souvenir_shop.api.dto.purchase.PurchaseDto;
import com.vladyka.souvenir_shop.api.dto.purchase.AllPurchases;
import com.vladyka.souvenir_shop.api.enums.Currency;
import com.vladyka.souvenir_shop.api.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    /**
     * localhost:8080/purchase
     */
    @PostMapping
    public AllPurchases savePurchase(@RequestBody PurchaseDto purchaseDto) throws ParseException {
        purchaseService.savePurchase(purchaseDto);
        return purchaseService.getAllPurchases();
    }

    /**
     * localhost:8080/purchase/all
     */
    @GetMapping(value = "/all")
    public AllPurchases allPurchases() throws ParseException {
        return purchaseService.getAllPurchases();
    }

    /**
     * localhost:8080/purchase/clear
     */
    @DeleteMapping(value = "/clear")
    public AllPurchases clearPurchase(@RequestParam String date) throws ParseException {
        purchaseService.clear(date);

        return purchaseService.getAllPurchases();
    }

    /**
     * localhost:8080/purchase/autopopulate
     */
    @GetMapping(value = "/autopopulate")
    public AllPurchases autopopulate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Purchase> purchases = Arrays.asList(
                new Purchase(simpleDateFormat.parse("2019-04-25"), 25.0, Currency.EUR, "Beer"),
                new Purchase(simpleDateFormat.parse("2018-03-25"), 2.5, Currency.USD, "Photo"),
                new Purchase(simpleDateFormat.parse("2019-04-25"), 1.5, Currency.PLN, "Bee"),
                new Purchase(simpleDateFormat.parse("2017-04-30"), 25.0, Currency.EUR, "Beer"),
                new Purchase(simpleDateFormat.parse("2019-08-12"), 10.0, Currency.UAH, "Soda")
        );
        purchaseService.saveAll(purchases);

        return purchaseService.getAllPurchases();
    }
}