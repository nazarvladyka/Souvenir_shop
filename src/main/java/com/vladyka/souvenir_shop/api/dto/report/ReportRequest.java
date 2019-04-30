package com.vladyka.souvenir_shop.api.dto.report;

public class ReportRequest {
    private Integer year;
    private String currency;

    public ReportRequest(Integer year, String currency) {
        this.year = year;
        this.currency = currency;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}