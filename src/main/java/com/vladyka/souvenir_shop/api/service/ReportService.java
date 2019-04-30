package com.vladyka.souvenir_shop.api.service;

import com.vladyka.souvenir_shop.api.dto.report.ReportRequest;
import com.vladyka.souvenir_shop.api.dto.report.ReportResponse;

import java.text.ParseException;

public interface ReportService {

    ReportResponse getReport(ReportRequest reportRequest) throws ParseException;
}