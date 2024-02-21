package com.example.currencyswapservice.service;

import com.example.currencyswapservice.model.CurrencyRate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyRateService {

    Map<String,CurrencyRate> currencyRates;

    public CurrencyRateService(){
        //sample response
        Date time = new Date();

        String USD = "USD";
        Map<String,Double> ratesForUSD = new HashMap<>();
        ratesForUSD.put("INR", 82.5);
        ratesForUSD.put("GBP", 0.79);
        ratesForUSD.put("CAD", 1.35);
        CurrencyRate currencyRateUSD = new CurrencyRate(USD,time,ratesForUSD,"None");

        String INR = "INR";
        Map<String,Double> ratesForINR= new HashMap<>();
        ratesForINR.put("USD",0.012);
        ratesForINR.put("CAD",0.016);
        ratesForINR.put("GBP",0.0096);
        CurrencyRate currencyRateINR = new CurrencyRate(INR,time,ratesForINR,"None");

        currencyRates = new HashMap<>();
        currencyRates.put(USD,currencyRateUSD);
        currencyRates.put(INR,currencyRateINR);
    }

    public CurrencyRate getCurrencyRatesForCurrency(String baseCurrencyCode){
        if(currencyRates.containsKey(baseCurrencyCode)){
            return currencyRates.get(baseCurrencyCode);
        }

        return new CurrencyRate("Currency exchange information for the given currency code is not supported currently - "+baseCurrencyCode);
    }

    public Map<String,CurrencyRate> getAllCurrencyRates(){
        return currencyRates;
    }

    public String updateCurrencyRate(CurrencyRate incomingCurrencyRate){
        currencyRates.put(incomingCurrencyRate.getBaseCurrency(), incomingCurrencyRate);
        return "Success";
    }

}
