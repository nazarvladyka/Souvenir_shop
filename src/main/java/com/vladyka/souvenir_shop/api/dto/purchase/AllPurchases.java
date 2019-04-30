package com.vladyka.souvenir_shop.api.dto.purchase;

import java.util.List;

public class AllPurchases {
    private List<DailyPurchases> dailyPurchases;

    public AllPurchases() {
    }

    public AllPurchases(List<DailyPurchases> dailyPurchases) {
        this.dailyPurchases = dailyPurchases;
    }

    public List<DailyPurchases> getDailyPurchases() {
        return dailyPurchases;
    }

    public void setDailyPurchases(List<DailyPurchases> dailyPurchases) {
        this.dailyPurchases = dailyPurchases;
    }
}
