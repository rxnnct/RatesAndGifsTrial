package ru.rxnnct.RatesAndGifsTrial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.rxnnct.RatesAndGifsTrial.client.GifClient;
import ru.rxnnct.RatesAndGifsTrial.client.RatesClient;
import ru.rxnnct.RatesAndGifsTrial.model.GifModel;
import ru.rxnnct.RatesAndGifsTrial.model.RatesModel;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class MainService {
    @Value("${ru.rxnnct.RatesAndGifsTrial.baseCurrency}")
    private String baseCurrency;
    @Value("${ru.rxnnct.RatesAndGifsTrial.currencyRiseTag}")
    private String currencyRiseTag;
    @Value("${ru.rxnnct.RatesAndGifsTrial.currencyFallTag}")
    private String currencyFallTag;
    @Value("${ru.rxnnct.RatesAndGifsTrial.dateFormat}")
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

        //Returns true if the currency is increased at the user's request
        return (((currentBaseCurrencyRate) / (currentCurrencyRate)) > ((yesterdayBaseCurrencyRate) / (yesterdayCurrencyRate)));
    }
}
