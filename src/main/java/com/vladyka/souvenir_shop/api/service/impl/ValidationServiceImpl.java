package com.vladyka.souvenir_shop.api.service.impl;

import com.vladyka.souvenir_shop.api.dto.purchase.PurchaseDto;
import com.vladyka.souvenir_shop.api.enums.Currency;
import com.vladyka.souvenir_shop.api.exceptions.*;
import com.vladyka.souvenir_shop.api.service.ValidationService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public void validateData(PurchaseDto purchaseDto) {
        validateDate(purchaseDto.getDate());
        validatePrice(purchaseDto.getPrice());
        validateCurrency(purchaseDto.getCurrency());
        validateProductName(purchaseDto.getProductName());
    }

    @Override
    public void validateDate(String dateS) {
        if (dateS == null) {
            throw new InvalidDateException("Date can't be NULL");
        } else if (dateS.equals("")) {
            throw new InvalidDateException("Date is empty");
        }

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(dateS);
        } catch (ParseException e) {
            throw new InvalidDateException("Invalid format of date");
        }
    }

    @Override
    public void validatePrice(Double price) {
        if (price == null) {
            throw new InvalidPriceException("Price can't be NULL");
        } else if(price < 0) {
            throw new InvalidPriceException("Price can't be less than zero");
        }
    }

    @Override
    public void validateCurrency(String currency) {
        if (currency == null) {
            throw new InvalidCurrencyException("Currency can't be NULL");
        } else if(Currency.of(currency) == null){
            throw new InvalidCurrencyException("Currency has invalid format");
        }
    }

    @Override
    public void validateProductName(String productName) {
        if (productName == null) {
            throw new InvalidProductNameException("ProductName can't be NULL");
        } else if (productName.equals("")) {
            throw new InvalidDateException("ProductName is empty");
        }
    }

    @Override
    public void validateYear(Integer year) {
        if (year == null) {
            throw new InvalidYearException("Year can't be NULL");
        } else if (year < 0) {
            throw new InvalidYearException("Year can't be less than zero");
        }
    }

    @Override
    public void validateAccessKey(String accessKey) {
        if (accessKey == null) {
            throw new NullPointerException("accessKey can't be NULL");
        }
    }
}