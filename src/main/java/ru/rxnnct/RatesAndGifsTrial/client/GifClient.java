package ru.rxnnct.RatesAndGifsTrial.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rxnnct.RatesAndGifsTrial.model.GifModel;

/**
 * Consumes data about gif images from a remote service
 */
@FeignClient(name = "GifClient", url = "${ru.rxnnct.RatesAndGifsTrial.gifsService}")
public interface GifClient {
    @GetMapping(value = "${ru.rxnnct.RatesAndGifsTrial.gifsMethod}", consumes = MediaType.APPLICATION_JSON_VALUE)
    GifModel getGif(@PathVariable("pathVariable") String pathVariable);
}
