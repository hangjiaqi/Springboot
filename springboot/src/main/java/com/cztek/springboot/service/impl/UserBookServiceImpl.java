package com.cztek.springboot.service.impl;

import com.cztek.springboot.utils.ObjectUtil;
import com.cztek.springboot.entity.ModelVo;
import com.cztek.springboot.entity.UserBook;
import com.cztek.springboot.repository.UserBookRepository;
import com.cztek.springboot.service.IUserBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookServiceImpl implements IUserBookService {
	@Autowired
	private UserBookRepository userBookRepository;

	@Override
	public UserBook save(UserBook userBook) {
		return userBookRepository.save(userBook);
	}

	@Override
	public List<UserBook> findByNowFoodDate() {
		return userBookRepository.findByNowFoodDate();
	}

	@Override
	public List<UserBook> findByUserIdAndFoodDate(Integer userId) {
		return userBookRepository.findByUserIdAndFoodDate(userId);
	}

	@Override
	public int deleteUserBook(Integer userBookId) {
		int deleteUserBookId = userBookRepository.deleteUserBookId(userBookId);
		return deleteUserBookId;
	}

	@Override
	public List<ModelVo> findCookBookDayAll() {
		try {
			List<Object[]> resultList = userBookRepository.findCookBookDay();
			return ObjectUtil.castEntity(resultList, ModelVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserBook> findByUserId(Integer id) {
		return userBookRepository.findByUserId(id);
	}

}
