package com.cztek.springboot.service;

import java.util.List;

import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.vo.CookBookVo;
import com.cztek.springboot.vo.FindCookBookWeekVo;

public interface ICookBookService {
	
	List<FindCookBookWeekVo> findWeekCook(String day);
	
	List<CookBook> finAll();

	CookBook findById(Integer Id);

	boolean uploadFile(List<CookBook> cookBooks);
	
	List<CookBook> findByRestaurantId(Integer Id);
	
	CookBook save(CookBook cookbook);
	
	List<CookBookVo> findByRestaurantAndCookName();
}
