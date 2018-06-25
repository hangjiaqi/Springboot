package com.cztek.springboot.service;

import java.util.List;

import com.cztek.springboot.entity.CookBook;

public interface ICookBookService {

    List<CookBook> finAll();
    CookBook findById(Integer Id);
}
