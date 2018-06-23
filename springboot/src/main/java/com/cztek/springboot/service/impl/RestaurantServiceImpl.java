package com.cztek.springboot.service.impl;

import com.cztek.springboot.com.cztek.entity.Restaurant;
import com.cztek.springboot.repository.RestaurantRepository;
import com.cztek.springboot.service.IRestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant findOne(int id) {
        return restaurantRepository.findById(id).get();
    }
}
