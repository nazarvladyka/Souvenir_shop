package com.vladyka.dto;

import java.util.List;

public class PurchasesReport {
    private List<DailyReport> dailyReports;

    public PurchasesReport() {
    }

    public PurchasesReport(List<DailyReport> dailyReports) {
        this.dailyReports = dailyReports;
    }

    public List<DailyReport> getDailyReports() {
        return dailyReports;
    }

    public void setDailyReports(List<DailyReport> dailyReports) {
        this.dailyReports = dailyReports;
    }
}
