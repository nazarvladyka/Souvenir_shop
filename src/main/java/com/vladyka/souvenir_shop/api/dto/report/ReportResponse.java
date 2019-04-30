package com.vladyka.souvenir_shop.api.dto.report;

public class ReportResponse {
    private Double sum;
    private String currency;

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}