package com.cztek.springboot.service.impl;


import com.cztek.springboot.repository.SnacksDetailRepository;
import com.cztek.springboot.service.ISnacksDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:杭佳琦
 * @Desciption: Date:Created in 19:59 2018/9/5
 * @Modified by:
 */

@Service
public class SnacksServiceDetailImpl implements ISnacksDetailService {

    @Autowired
    SnacksDetailRepository snacksDetailRepository;
}
