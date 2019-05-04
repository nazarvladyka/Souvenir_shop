package com.vladyka.souvenir_shop.api.service;

import com.vladyka.souvenir_shop.api.dto.purchase.PurchaseDto;

public interface ValidationService {
    void validateData(PurchaseDto purchaseDto);

    void validateDate(String dateS);

    void validatePrice(Double price);

    void validateCurrency(String currency);

    void validateProductName(String productName);

    void validateYear(Integer year);

    void validateAccessKey(String accessKey);
}