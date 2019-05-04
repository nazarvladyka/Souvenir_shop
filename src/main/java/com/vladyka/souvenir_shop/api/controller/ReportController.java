package com.vladyka.souvenir_shop.api.controller;

import com.vladyka.souvenir_shop.api.dto.report.ReportRequest;
import com.vladyka.souvenir_shop.api.dto.report.ReportResponse;
import com.vladyka.souvenir_shop.api.service.ReportService;
import com.vladyka.souvenir_shop.api.service.ValidationService;
import com.vladyka.souvenir_shop.api.service.impl.ValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/report")
public class ReportController {
    private ValidationService validationService = new ValidationServiceImpl();
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * localhost:8080/report
     */
    @RequestMapping
    public ReportResponse getYearReport(@RequestParam Integer year, String currency) throws ParseException {
        validationService.validateYear(year);
        validationService.validateCurrency(currency);

        return reportService.getReport(new ReportRequest(year, currency));
    }
}