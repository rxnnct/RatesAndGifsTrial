package ru.rxnnct.RatesAndGifsTrial.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rxnnct.RatesAndGifsTrial.api.client.RatesClient;
import ru.rxnnct.RatesAndGifsTrial.api.model.RatesModel;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/get-gif")
public class MainController {
    @Autowired
    RatesClient ratesClient;

    @GetMapping()
    public RatesModel getRates()
    {
        return ratesClient.getYesterdayRates(LocalDateTime.now().minus(Period.ofDays(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
