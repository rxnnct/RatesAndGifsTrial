package ru.rxnnct.RatesAndGifsTrial.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rxnnct.RatesAndGifsTrial.api.model.RatesModel;

@FeignClient(name = "RatesClient", url = "https://openexchangerates.org/")
public interface RatesClient {
    String currentRatesUrl = "/api/latest.json?app_id=59935cd9e660427683adf80067f4bdc0";

    @GetMapping(value = currentRatesUrl,consumes = MediaType.APPLICATION_JSON_VALUE)
    RatesModel getCurrentRates();

    @GetMapping(value = "/api/historical/{pathVariable}.json?app_id=59935cd9e660427683adf80067f4bdc0",consumes = MediaType.APPLICATION_JSON_VALUE)
    RatesModel getYesterdayRates(@PathVariable("pathVariable") String pathVariable);
}
