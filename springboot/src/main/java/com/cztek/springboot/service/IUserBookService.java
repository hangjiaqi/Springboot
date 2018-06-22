package com.cztek.springboot.service;

import com.cztek.springboot.com.cztek.entity.UserBook;

import java.util.Date;
import java.util.List;

public interface IUserBookService {
	   UserBook save(UserBook userBook);
	    List<UserBook> findByNowFoodDate();
	    List<UserBook> findByUserIdAndFoodDate(Integer userId);
}
