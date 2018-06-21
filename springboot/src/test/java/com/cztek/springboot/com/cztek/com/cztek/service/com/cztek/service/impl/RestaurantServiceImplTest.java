package com.cztek.springboot.com.cztek.com.cztek.service.com.cztek.service.impl;

import com.cztek.springboot.com.cztek.entity.CookBook;
import com.cztek.springboot.com.cztek.entity.Restaurant;
import com.cztek.springboot.com.cztek.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTest {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Test
    public void findOne() {
        /*
        Restaurant restaurant = restaurantRepository.findById(1).get();
        Set<CookBook> cookBookSet = restaurant.getCookBookSet();
        Iterator<CookBook> iterator = cookBookSet.iterator();
        while(iterator.hasNext()){
            String cookname = iterator.next().getCookname();
            log.info(cookname);
        }*/
    }
}