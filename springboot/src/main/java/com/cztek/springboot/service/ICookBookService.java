package com.cztek.springboot.service;

import java.util.List;

import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.CookBookVo;

public interface ICookBookService {

	List<CookBook> finAll();

	CookBook findById(Integer Id);

	boolean uploadFile(List<CookBook> cookBooks);
	
	List<CookBook> findByRestaurantId(Integer Id);
	
	CookBook save(CookBook cookbook);
	
	List<CookBookVo> findByRestaurantAndCookName();
}
