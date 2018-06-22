package com.cztek.springboot.service.impl;

import com.cztek.springboot.com.cztek.entity.CookBook;
import com.cztek.springboot.repository.CookBootRepository;
import com.cztek.springboot.service.ICookBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CookBookServiceImpl implements ICookBookService {


    @Autowired
    private CookBootRepository cookBookRepository;

    @Override
    public List<CookBook> finAll() {
        return cookBookRepository.findAll();
    }

    @Override
    public CookBook findById(Integer Id) {
        /**
         * 如果CookBook中没有数据则返回空,
         * 如果有数据则返回实体
         */
        return cookBookRepository.findById(Id).orElse(null);
    }
}