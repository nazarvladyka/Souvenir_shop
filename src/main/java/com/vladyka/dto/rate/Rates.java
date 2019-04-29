package com.vladyka.dto.rate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
    private double USD;
    private double UAH;
    private double PLN;

    public double getUSD() {
        return USD;
    }

    @JsonProperty(value = "USD")
    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getUAH() {
        return UAH;
    }

    @JsonProperty(value = "UAH")
    public void setUAH(double UAH) {
        this.UAH = UAH;
    }

    public double getPLN() {
        return PLN;
    }

    @JsonProperty(value = "PLN")
    public void setPLN(double PLN) {
        this.PLN = PLN;
    }
}
