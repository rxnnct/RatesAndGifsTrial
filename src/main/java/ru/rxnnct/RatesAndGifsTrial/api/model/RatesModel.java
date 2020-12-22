package ru.rxnnct.RatesAndGifsTrial.api.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class RatesModel {
//    private String disclaimer;
//    private String license;
//    private int id;
//    private String base;
    private HashMap<String, Float> rates;
}
