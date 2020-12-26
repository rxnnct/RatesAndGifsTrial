package ru.rxnnct.RatesAndGifsTrial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rxnnct.RatesAndGifsTrial.model.GifData;
import ru.rxnnct.RatesAndGifsTrial.service.MainService;

@RestController
@RequestMapping("/api/get-gif")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("{currency}")
    public GifData getGifByRates(@PathVariable("currency") String currency) {
        return mainService.getGif(currency).getData();
    }
}