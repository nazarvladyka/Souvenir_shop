package com.vladyka.service;

import com.vladyka.enums.Currency;

public interface ExchangeRateService {

    double getExchangeRate(Currency currency);

//    ExchangeRate saveExchangeRate(ExchangeRate exchangeRate);
}