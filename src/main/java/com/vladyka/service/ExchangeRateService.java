package com.vladyka.service;

import com.vladyka.dto.ReportRequest;
import com.vladyka.dto.ReportResponse;
import com.vladyka.enums.Currency;

import java.text.ParseException;

public interface ExchangeRateService {

    double getExchangeRate(Currency currency);

    ReportResponse getReport(ReportRequest reportRequest) throws ParseException;

//    ExchangeRate saveExchangeRate(ExchangeRate exchangeRate);
}