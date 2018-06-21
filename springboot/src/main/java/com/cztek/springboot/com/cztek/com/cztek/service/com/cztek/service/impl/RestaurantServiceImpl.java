package com.cztek.springboot.com.cztek.com.cztek.service.com.cztek.service.impl;

import com.cztek.springboot.com.cztek.com.cztek.service.IRestaurantService;
import com.cztek.springboot.com.cztek.entity.Restaurant;
import com.cztek.springboot.com.cztek.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Resource
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant findOne(int id) {
        return restaurantRepository.findById(id).get();
    }
}
