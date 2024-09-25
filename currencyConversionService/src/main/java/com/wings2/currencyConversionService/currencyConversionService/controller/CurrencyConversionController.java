package com.wings2.currencyConversionService.currencyConversionService.controller;

import com.wings2.currencyConversionService.currencyConversionService.configuration.CurrencyExchangeProxy;
import com.wings2.currencyConversionService.currencyConversionService.pojo.CurrencyConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.spi.CurrencyNameProvider;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeProxy proxy;

    @GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateConversion(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){


        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> currencyConversionResponseEntity = new RestTemplate()
                .getForEntity("http://localhost:7000/currency-service/from/{from}/to/{to}",CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = currencyConversionResponseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(), currencyConversion.getInput(), currencyConversion.getOutput(),
                quantity, currencyConversion.getExchangeValue(), currencyConversion.getEnvironment(), quantity.multiply(currencyConversion.getExchangeValue()) );

    }

    @GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateConversionOpenFeign(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = proxy.calculateConversion(from, to);
        return new CurrencyConversion(currencyConversion.getId(), currencyConversion.getInput(), currencyConversion.getOutput(),
                quantity, currencyConversion.getExchangeValue(), currencyConversion.getEnvironment(), quantity.multiply(currencyConversion.getExchangeValue()) );

        RestTemplate restTemplate= new RestTemplate();
                restTemplate.po

    }

}
