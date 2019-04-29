package com.vladyka.dto.purchase;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PurchasesReport {
    private List<DailyReport> dailyReports;

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
