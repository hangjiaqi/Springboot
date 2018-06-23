package com.cztek.springboot.service;

import com.cztek.springboot.com.cztek.entity.CookBook;

import java.util.List;

public interface ICookBookService {

    List<CookBook> finAll();
    CookBook findById(Integer Id);
}
