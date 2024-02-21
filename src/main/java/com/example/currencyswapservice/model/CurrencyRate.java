package com.example.currencyswapservice.model;

import java.util.Date;
import java.util.Map;

public class CurrencyRate {

    private String baseCurrency;
    private Date time;
    private Map<String,Double> rates;

    private String error;

    public CurrencyRate(){

    }

    public CurrencyRate(String baseCurrency, Date time, Map<String,Double> rates, String error){
        this.baseCurrency = baseCurrency;
        this.time = time;
        this.rates = rates;
        this.error = error;
    }

    public CurrencyRate(String error){
        this.error = error;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
