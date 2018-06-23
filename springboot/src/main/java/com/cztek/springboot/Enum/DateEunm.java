package com.cztek.springboot.Enum;

import lombok.Data;

public enum DateEunm {
    MORNING(1,"早上"),
    NOON(2,"中午"),
    AFTER(3,"晚上"),
    ;
    private int code;
    private String message;
    DateEunm(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
