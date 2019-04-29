package com.vladyka.controller;

import com.vladyka.domain.Purchase;
import com.vladyka.dto.PurchaseDto;
import com.vladyka.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/purchase")
    public String savePurchase(@RequestBody PurchaseDto purchaseDto) throws ParseException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(purchaseDto.getDate());

        Purchase purchase = new Purchase(purchaseDto.getId(),
                date,
                purchaseDto.getPrice(),
                purchaseDto.getCurrency(),
                purchaseDto.getProductName());

        return purchaseService.save(purchase).toString();
    }
}
