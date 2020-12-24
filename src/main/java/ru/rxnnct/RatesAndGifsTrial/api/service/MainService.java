package ru.rxnnct.RatesAndGifsTrial.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rxnnct.RatesAndGifsTrial.api.client.GifClient;
import ru.rxnnct.RatesAndGifsTrial.api.client.RatesClient;
import ru.rxnnct.RatesAndGifsTrial.api.model.GifModel;
import ru.rxnnct.RatesAndGifsTrial.api.model.RatesModel;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class MainService {
        private final RatesClient ratesClient;
        private final GifClient gifClient;

    @Autowired
    public MainService(RatesClient ratesClient, GifClient gifClient) {
        this.ratesClient = ratesClient;
        this.gifClient = gifClient;
    }

    public GifModel getGif(){
        System.out.println(checkRates());
        return new GifModel();//dummy
    }

    private boolean checkRates(){
        RatesModel yesterdayRatesRates = ratesClient.getYesterdayRates(LocalDateTime.now().minus(Period.ofDays(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Float yesterdayCurrencyRate = yesterdayRatesRates.getRates().get("USD");
        Float yesterdayRoubleRate = yesterdayRatesRates.getRates().get("RUB");

        RatesModel currentRates = ratesClient.getCurrentRates();
        Float currentCurrencyRate = currentRates.getRates().get("USD");
        Float currentRoubleRate = currentRates.getRates().get("RUB");

        return (((currentRoubleRate) / (currentCurrencyRate)) > ((yesterdayRoubleRate) / (yesterdayCurrencyRate)));
    }
}
