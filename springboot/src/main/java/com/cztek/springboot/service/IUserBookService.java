package com.cztek.springboot.service;


import java.util.List;

import com.cztek.springboot.entity.FindMonthOrder;
import com.cztek.springboot.vo.ModelVo;
import com.cztek.springboot.entity.UserBook;



public interface IUserBookService {
	UserBook save(UserBook userBook);

	List<UserBook> findByNowFoodDate();

	List<UserBook> findByUserIdAndFoodDate(Integer userId);
	
	int deleteUserBook(Integer userBookId);
	
	List<ModelVo> findCookBookDayAll();
	
	List<UserBook> findByUserId(Integer id);

	List<FindMonthOrder> findMonthOrder();

	int findIntradayOrder();

}
