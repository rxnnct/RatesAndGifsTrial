# RatesAndGifsTrial

## Installing and running
* Add parameters to the ```application.config``` file:
  
  ```ru.rxnnct.RatesAndGifsTrial.baseCurrency=RUB
  
  ru.rxnnct.RatesAndGifsTrial.currencyRiseTag=rich
  ru.rxnnct.RatesAndGifsTrial.currencyFallTag=broke
  ru.rxnnct.RatesAndGifsTrial.dateFormat=yyyy-MM-dd
  
  ru.rxnnct.RatesAndGifsTrial.ratesService=https://openexchangerates.org/
  ru.rxnnct.RatesAndGifsTrial.gifsService=https://api.giphy.com/
  
  ru.rxnnct.RatesAndGifsTrial.currentRatesMethod=/api/latest.json?app_id=_**YOUR_APP_ID**_
  ru.rxnnct.RatesAndGifsTrial.yesterdayRatesMethod=/api/historical/{pathVariable}.json?app_id=_**YOUR_APP_ID**_
  
  ru.rxnnct.RatesAndGifsTrial.gifsMethod=/v1/gifs/random?api_key=_**YOUR_API_KEY**_={pathVariable}
* ```git clone https://github.com/rxnnct/RatesAndGifsTrial.git```
* ```gradle clean build<br>```
* ```gradlew bootRun``` or ```java -jar /build/libs/RatesAndGifsTrial-0.0.1-SNAPSHOT.jar```

## How to use

