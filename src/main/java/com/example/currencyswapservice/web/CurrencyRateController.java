package com.example.currencyswapservice.web;

import com.example.currencyswapservice.model.CurrencyRate;
import com.example.currencyswapservice.model.Health;
import com.example.currencyswapservice.service.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/currency-rate")
public class CurrencyRateController {

    CurrencyRateService currencyRateService;

    @Autowired
    public CurrencyRateController(CurrencyRateService currencyRateService){
        this.currencyRateService =  currencyRateService;
    }

    @GetMapping("/health")
    public ResponseEntity<Health> isHealthy(){
        return new ResponseEntity<>(new Health(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getRates")
    public CurrencyRate getCurrencyRatesForCurrency(@RequestParam String baseCurrency){
        return currencyRateService.getCurrencyRatesForCurrency(baseCurrency);
    }

    @GetMapping("/getAllRates")
    public Map<String,CurrencyRate> getAllRates(){
        return currencyRateService.getAllCurrencyRates();
    }

    @PostMapping("/addRates")
    public String addRates(@RequestBody CurrencyRate currencyRate){
        return currencyRateService.updateCurrencyRate(currencyRate);
    }

}
