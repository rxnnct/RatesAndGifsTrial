package ru.rxnnct.RatesAndGifsTrial.api.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class RatesModel {
    private HashMap<String, Float> rates;
}
