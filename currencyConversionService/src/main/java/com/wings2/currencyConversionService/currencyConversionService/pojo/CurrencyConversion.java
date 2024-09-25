package com.wings2.currencyConversionService.currencyConversionService.pojo;

import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversion {

    @Id
    private Long id;
    private String input;
    private String output;
    private BigDecimal quantity;
    private BigDecimal exchangeValue;

    private String environment;
    private BigDecimal totalCalculatedValue;

    public CurrencyConversion(Long id, String input, String output,  BigDecimal quantity,
                              BigDecimal exchangeValue, String environment, BigDecimal totalCalculatedValue) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.exchangeValue = exchangeValue;
        this.quantity = quantity;
        this.environment = environment;
        this.totalCalculatedValue = totalCalculatedValue;
    }
}
