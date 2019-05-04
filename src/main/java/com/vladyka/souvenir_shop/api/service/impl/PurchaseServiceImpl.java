package com.vladyka.souvenir_shop.api.service.impl;

import com.vladyka.souvenir_shop.api.domain.Purchase;
import com.vladyka.souvenir_shop.api.dto.purchase.DailyPurchases;
import com.vladyka.souvenir_shop.api.dto.purchase.PurchaseDto;
import com.vladyka.souvenir_shop.api.dto.purchase.PurchaseWODate;
import com.vladyka.souvenir_shop.api.dto.purchase.AllPurchases;
import com.vladyka.souvenir_shop.api.enums.Currency;
import com.vladyka.souvenir_shop.api.repository.PurchaseRepository;
import com.vladyka.souvenir_shop.api.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void savePurchase(PurchaseDto purchaseDto) throws ParseException {
        Date date = simpleDateFormat.parse(purchaseDto.getDate());
        Currency currency = Currency.valueOf(purchaseDto.getCurrency());

        Purchase purchase = new Purchase(date, purchaseDto.getPrice(),
                currency, purchaseDto.getProductName());

        purchaseRepository.save(purchase);
    }

    @Override
    public void saveAll(List<Purchase> purchases) {
        purchaseRepository.saveAll(purchases);
    }

    @Override
    public AllPurchases getAllPurchases() {
        AllPurchases allPurchases = new AllPurchases();

        Set<Date> dates = getPurchasesDates();
        List<DailyPurchases> dailyPurchases = new ArrayList<>();

        for (Date date : dates) {
            dailyPurchases.add(getDailyPurchases(date));
        }
        allPurchases.setDailyPurchases(dailyPurchases);

        return allPurchases;
    }

    @Override
    public List<Purchase> getAllPurchasesByYear(int year) {
        Date start = new GregorianCalendar(year, 0, 1).getTime();
        Date end = new GregorianCalendar(year+1, 0, 1).getTime();

        return newArrayList(purchaseRepository.findAllByDateBetween(start, end));
    }

    @Override
    public DailyPurchases getDailyPurchases(Date date) {
        DailyPurchases dailyPurchases = new DailyPurchases();

        List<PurchaseWODate> purchasesDtoWODate = new ArrayList<>();
        List<Purchase> purchases =  newArrayList(purchaseRepository.findAllByDate(date));

        for(Purchase p : purchases) {
            purchasesDtoWODate.add(getPurchaseWithoutDate(p));
        }

        String dateS = simpleDateFormat.format(date);

        dailyPurchases.setDate(dateS);
        dailyPurchases.setPurchases(purchasesDtoWODate);

        return dailyPurchases;
    }

    @Transactional
    @Override
    public int clear(String dateS) throws ParseException {
        Date date = simpleDateFormat.parse(dateS);

        return purchaseRepository.deleteAllByDate(date);
    }

    private PurchaseWODate getPurchaseWithoutDate(Purchase purchase) {
        PurchaseWODate purchaseWODate = new PurchaseWODate();

        purchaseWODate.setProductName(purchase.getProductName());
        purchaseWODate.setPrice(purchase.getPrice());
        purchaseWODate.setCurrency(purchase.getCurrency());

        return purchaseWODate;
    }

    private Set<Date> getPurchasesDates() {
        Set<Date> dates = new TreeSet<>(Comparator.naturalOrder());
        Iterable<Purchase> purchases = purchaseRepository.findAllByOrderByDate();

        for(Purchase p : purchases) {
            dates.add(p.getDate());
        }

        return dates;
    }
}