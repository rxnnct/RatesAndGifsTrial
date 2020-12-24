package ru.rxnnct.RatesAndGifsTrial.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rxnnct.RatesAndGifsTrial.api.model.GifModel;
import ru.rxnnct.RatesAndGifsTrial.api.service.MainService;

@RestController
@RequestMapping("/api/get-gif")
public class MainController {
    private final MainService mainService;

//    @GetMapping("{id}")
//    public ProxyProperty getOne(@PathVariable("id") ProxyProperty proxyProperty) {
//        return proxyProperty;
//    }

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("{currency}")
    public GifModel getGifByRates(@PathVariable("currency") String currency) {
        return mainService.getGif(currency);
    }
}