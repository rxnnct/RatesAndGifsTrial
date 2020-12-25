package ru.rxnnct.RatesAndGifsTrial.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${baseCurrency}")
    private String baseCurrency;
    @Value("${currencyRiseTag}")
    private String currencyRiseTag;
    @Value("${currencyFallTag}")
    private String currencyFallTag;
    @Value("${dateFormat}")
    private String dateFormat;

    private final RatesClient ratesClient;
    private final GifClient gifClient;

    @Autowired
    public MainService(RatesClient ratesClient, GifClient gifClient) {
        this.ratesClient = ratesClient;
        this.gifClient = gifClient;
    }

    public GifModel getGif(String currency){
        if (checkRates(currency.toUpperCase())){
            return gifClient.getGif(currencyRiseTag);
        } else {
            return gifClient.getGif(currencyFallTag);
        }
    }

    private boolean checkRates(String currency){
        RatesModel yesterdayRates = ratesClient.getYesterdayRates(LocalDateTime.now().minus(Period.ofDays(1)).format(DateTimeFormatter.ofPattern(dateFormat)));
        Float yesterdayCurrencyRate = yesterdayRates.getRates().get(currency);
        Float yesterdayBaseCurrencyRate = yesterdayRates.getRates().get(baseCurrency);

        RatesModel currentRates = ratesClient.getCurrentRates();
        Float currentCurrencyRate = currentRates.getRates().get(currency);
        Float currentBaseCurrencyRate = currentRates.getRates().get(baseCurrency);

        return (((currentBaseCurrencyRate) / (currentCurrencyRate)) > ((yesterdayBaseCurrencyRate) / (yesterdayCurrencyRate)));
    }
}
