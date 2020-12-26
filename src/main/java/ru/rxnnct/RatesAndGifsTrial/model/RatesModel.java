package ru.rxnnct.RatesAndGifsTrial.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class RatesModel {
    private HashMap<String, Float> rates;
}
