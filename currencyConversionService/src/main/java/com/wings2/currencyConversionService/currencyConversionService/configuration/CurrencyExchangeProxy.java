package com.wings2.currencyConversionService.currencyConversionService.configuration;


import com.wings2.currencyConversionService.currencyConversionService.pojo.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name="currency-service", url = "http://localhost:8000")
public interface CurrencyExchangeProxy {


    @GetMapping("currency-service/from/{from}/to/{to}")
    public CurrencyConversion calculateConversion(@PathVariable String from, @PathVariable String to);


}
