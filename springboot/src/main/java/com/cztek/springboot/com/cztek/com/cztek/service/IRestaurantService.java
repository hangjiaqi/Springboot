package com.cztek.springboot.com.cztek.com.cztek.service;

import com.cztek.springboot.com.cztek.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

   /*List<Restaurant> selectByName(Integer id);*/

    Restaurant findOne(int id);
}
