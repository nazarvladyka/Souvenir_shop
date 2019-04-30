package com.vladyka.souvenir_shop.api.dto.rate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
    private Double USD;
    private Double UAH;
    private Double PLN;

    public Double getUSD() {
        return USD;
    }

    @JsonProperty(value = "USD")
    public void setUSD(Double USD) {
        this.USD = USD;
    }

    public Double getUAH() {
        return UAH;
    }

    @JsonProperty(value = "UAH")
    public void setUAH(Double UAH) {
        this.UAH = UAH;
    }

    public Double getPLN() {
        return PLN;
    }

    @JsonProperty(value = "PLN")
    public void setPLN(Double PLN) {
        this.PLN = PLN;
    }
}