package com.vladyka.service.impl;

import com.vladyka.enums.Currency;
//import com.vladyka.repository.ExchangeRateRepository;
import com.vladyka.service.ExchangeRateService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

//    @Autowired
//    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public double getExchangeRate(Currency currency) {
        double exchangeRate = 29.8; //get this value from API
        return exchangeRate;
    }

//    @Override
//    public ExchangeRate saveExchangeRate(ExchangeRate exchangeRate) {
//        return exchangeRateRepository.save(exchangeRate);
    }
//}
