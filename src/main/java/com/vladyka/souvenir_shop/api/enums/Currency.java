package com.vladyka.souvenir_shop.api.enums;

public enum Currency {
    EUR, USD, UAH, PLN;

    public static Currency of(String s) {
        for(Currency currency : Currency.values()) {
            if(currency.toString().equals(s)){
                return currency;
            }
        }
        return null;
    }
}