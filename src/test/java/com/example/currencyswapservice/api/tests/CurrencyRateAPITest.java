package com.example.currencyswapservice.api.tests;

import com.example.currencyswapservice.model.CurrencyRate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyRateAPITest{
    static Map<String, CurrencyRate> currencyRates = new HashMap<>();

    public static void main(String args[])  throws MalformedURLException, IOException {

         URL url = new URL("http://localhost:8080/currency-rate/getAllRates");

         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         int responseCode = connection.getResponseCode();

         if(responseCode == 200){

             StringBuffer sb = new StringBuffer();
             Scanner scanner = new Scanner(connection.getInputStream());
             while(scanner.hasNext()){
                 sb.append(scanner.next());
             }
             String json = String.valueOf(sb);
             ObjectMapper objectMapper = new ObjectMapper();
             currencyRates = objectMapper.readValue(json, new TypeReference<Map<String,CurrencyRate>>(){});

             System.out.println("10 USD in INR : " + getExchangeValue("USD", "INR",  10.0));

         }

    }

    public static Double getExchangeValue(String baseCurrency,String counterCurrency,Double quantity){
        if(currencyRates.containsKey(baseCurrency)){
            Map<String,Double> rates = currencyRates.get(baseCurrency).getRates();
            if(rates.containsKey(counterCurrency)){
                Double counterCurrencyRate = rates.get(counterCurrency);
                System.out.println("Rate is : " +counterCurrencyRate);
                Double exchangeValue = counterCurrencyRate * quantity;
                return exchangeValue;
            }
        }
        return null;
    }
}
