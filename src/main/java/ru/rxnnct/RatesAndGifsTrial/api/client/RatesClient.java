package ru.rxnnct.RatesAndGifsTrial.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rxnnct.RatesAndGifsTrial.api.model.RatesModel;

@FeignClient(name = "RatesClient", url = "${ru.rxnnct.RatesAndGifsTrial.ratesService}")
public interface RatesClient {
    @GetMapping(value = "${ru.rxnnct.RatesAndGifsTrial.currentRatesMethod}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RatesModel getCurrentRates();

    @GetMapping(value = "${ru.rxnnct.RatesAndGifsTrial.yesterdayRatesMethod}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RatesModel getYesterdayRates(@PathVariable("pathVariable") String pathVariable);
}
