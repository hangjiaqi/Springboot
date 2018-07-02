package com.cztek.springboot.service;


import org.springframework.web.multipart.MultipartFile;

import com.cztek.springboot.entity.Message;
import com.cztek.springboot.entity.Restaurant;

public interface IRestaurantService {

	Restaurant findOne(int id);
	
	Restaurant findByName(String name);
	
	Restaurant save(Restaurant restaurant);
	
	Message checkRestaurantName(MultipartFile file,String name,String telephonee,String sale);
}
