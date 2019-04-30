package com.vladyka.controller;

import com.vladyka.dto.ReportRequest;
import com.vladyka.dto.ReportResponse;
import com.vladyka.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping(value = "/report")
    public ReportResponse getReportYear(@RequestBody ReportRequest reportRequest) throws ParseException {
        return exchangeRateService.getReport(reportRequest);
    }
}
