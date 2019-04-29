package com.vladyka.service;

import com.vladyka.enums.Currency;

public interface CurrencyService {

    double getExchangeRate(Currency currency);
}