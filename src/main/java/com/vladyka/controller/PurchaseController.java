package com.vladyka.controller;

import com.vladyka.dto.PurchaseDto;
import com.vladyka.dto.PurchasesReport;
import com.vladyka.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/purchase")
    @ResponseBody
    public PurchasesReport savePurchase(@RequestBody PurchaseDto purchaseDto) throws ParseException {
        purchaseService.savePurchaseDto(purchaseDto);
        return purchaseService.getPurchasesReport();
    }
}
