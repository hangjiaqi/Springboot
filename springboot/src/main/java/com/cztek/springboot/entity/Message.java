package com.cztek.springboot.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class Message {
    private Integer code = 200;
    private boolean result = false;
    private Object content;
    private List<String> messages = new ArrayList<>();
    private String message;

    public Message() {
    }

    public Message(boolean result) {
        this.result = result;
    }

    public Message(Integer code,boolean result, String message) {
        this.code =code;
        this.result = result;
        this.message = message;
    }

    public Message(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public Message(Integer code, boolean result, Object content) {
        this.code = code;
        this.result = result;
        this.content = content;
    }

    public Message(Boolean result, String message, Object content) {
        this.result = result;
        this.message = message;
        this.content = content;
    }


    public Message(Integer code, boolean result) {
        this.code = code;
        this.result = result;
    }

    public String toString() {
        String result = "";
        for (String s : new HashSet<>(messages)) {
            result += (s + "\n");
        }

        return StringUtils.strip(result, "\n");
    }
}
