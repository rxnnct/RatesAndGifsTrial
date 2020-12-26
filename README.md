# RatesAndGifsTrial

## About
An application that checks if the selected currency is growing and, based on the result, gives an answer in the form of a thematic GIF. This is a trial task.<br> 
Demo: https://ratesandgifstrial.herokuapp.com/api/get-gif/usd

## Installing and running
* ```git clone https://github.com/rxnnct/RatesAndGifsTrial.git```
* Add parameters to the ```application.config``` file. For example:
  
  ```ru.rxnnct.RatesAndGifsTrial.baseCurrency=RUB
  
  ru.rxnnct.RatesAndGifsTrial.currencyRiseTag=rich
  ru.rxnnct.RatesAndGifsTrial.currencyFallTag=broke
  ru.rxnnct.RatesAndGifsTrial.dateFormat=yyyy-MM-dd
  
  ru.rxnnct.RatesAndGifsTrial.ratesService=https://openexchangerates.org/
  ru.rxnnct.RatesAndGifsTrial.gifsService=https://api.giphy.com/
  
  ru.rxnnct.RatesAndGifsTrial.currentRatesMethod=/api/latest.json?app_id=[YOUR_APP_ID]
  ru.rxnnct.RatesAndGifsTrial.yesterdayRatesMethod=/api/historical/{pathVariable}.json?app_id=[YOUR_APP_ID]
  
  ru.rxnnct.RatesAndGifsTrial.gifsMethod=/v1/gifs/random?api_key=[YOUR_API_KEY]&tag={pathVariable}
* ```gradle clean build```
* ```gradlew bootRun``` or ```java -jar /build/libs/RatesAndGifsTrial-0.0.1-SNAPSHOT.jar```

## How to use
You can make a get-request to the service in any convenient form.<br>

Examples for ```http://localhost:8080``` and ```usd``` currency:<br>
* Browser address bar: ```http://localhost:8080/api/get-gif/usd```<br>
* Browser console (js): ```fetch('http://localhost:8080/api/get-gif/usd').then(response => response.json().then(console.log))```<br>
* cURL: ```curl http://localhost:8080/api/get-gif/usd```<br>

## Implementation details
* Spring Framework
* Feign Client
* Gradle
* Lombok