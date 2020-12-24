package ru.rxnnct.RatesAndGifsTrial.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rxnnct.RatesAndGifsTrial.api.model.RatesModel;

@FeignClient(name = "GifClient", url = "https://api.giphy.com/")
public interface GifClient {
    @GetMapping(value = "v1/gifs/random?api_key=60TL69cU9gSJjbcqdngmEo3JpJYPicmm&tag={pathVariable}",consumes = MediaType.APPLICATION_JSON_VALUE)
    RatesModel getGif(@PathVariable("pathVariable") String pathVariable);
}
