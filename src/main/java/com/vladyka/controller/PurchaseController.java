package com.vladyka.controller;

import com.vladyka.dto.PurchaseDto;
import com.vladyka.dto.PurchasesReport;
import com.vladyka.enums.Currency;
import com.vladyka.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    @ResponseBody
    //localhost:8080/purchase
    public PurchasesReport savePurchase(@RequestBody PurchaseDto purchaseDto) throws ParseException {
        purchaseService.savePurchase(purchaseDto);
        return purchaseService.getPurchasesReport();
    }

    //localhost:8080/purchase/all
    @GetMapping(value = "/all")
    public PurchasesReport allPurchases() throws ParseException {
        return purchaseService.getPurchasesReport();
    }

    //localhost:8080/purchase/clear/{date}
    @DeleteMapping(value = "/clear/{date}")
    public PurchasesReport clearPurchase(@PathVariable String date) throws ParseException {
        purchaseService.clear(date);

        return purchaseService.getPurchasesReport();
    }

    //localhost:8080/purchase/autopopulate
    @GetMapping(value = "/autopopulate")
    public void autopopulate() throws ParseException {
        PurchaseDto purchaseDto1 = new PurchaseDto("2019-04-25", 25, Currency.EUR, "Beer");
        PurchaseDto purchaseDto2 = new PurchaseDto("2018-03-25", 2.5, Currency.USD, "Photo");
        PurchaseDto purchaseDto3 = new PurchaseDto("2019-04-25", 1.5, Currency.PLN, "Bee");
        PurchaseDto purchaseDto4 = new PurchaseDto("2017-04-30", 25, Currency.EUR, "Beer");
        PurchaseDto purchaseDto5 = new PurchaseDto("2019-08-12", 10, Currency.UAH, "Soda");

        purchaseService.savePurchase(purchaseDto1);
        purchaseService.savePurchase(purchaseDto2);
        purchaseService.savePurchase(purchaseDto3);
        purchaseService.savePurchase(purchaseDto4);
        purchaseService.savePurchase(purchaseDto5);
    }
}
