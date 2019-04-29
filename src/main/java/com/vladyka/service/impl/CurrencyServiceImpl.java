package com.vladyka.service.impl;

import com.vladyka.enums.Currency;
import com.vladyka.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public double getExchangeRate(Currency currency) {
        double exchangeRate = 29.8; //get this value from API
        return exchangeRate;
    }
}
