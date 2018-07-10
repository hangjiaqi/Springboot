package com.cztek.springboot.entity;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class FindMonthOrder {

    private String name;
    private String telephone_number;
    private BigDecimal allPrice;
    private String month;

    public FindMonthOrder(String name, String telephone_number, BigDecimal allPrice, String month) {
        this.name = name;
        this.telephone_number = telephone_number;
        this.allPrice = allPrice;
        this.month = month;
    }

    public FindMonthOrder() {
    }
}
