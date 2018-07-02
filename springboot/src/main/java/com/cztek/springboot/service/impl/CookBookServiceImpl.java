package com.cztek.springboot.service.impl;

import com.cztek.springboot.Util.ObjectUtil;
import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.CookBookVo;
import com.cztek.springboot.entity.ModelVo;
import com.cztek.springboot.repository.CookBookRepository;
import com.cztek.springboot.service.ICookBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookBookServiceImpl implements ICookBookService {

	@Autowired
	private CookBookRepository cookBookRepository;

	@Override
	public List<CookBook> finAll() {
		return cookBookRepository.findAll();
	}

	@Override
	public CookBook findById(Integer Id) {
		/**
		 * 如果CookBook中没有数据则返回空, 如果有数据则返回实体
		 */
		return cookBookRepository.findById(Id).orElse(null);
	}

	@Override
	public boolean uploadFile(List<CookBook> cookBooks) {
		if (cookBooks != null && cookBooks.size() > 0) {
			cookBooks = cookBookRepository.saveAll(cookBooks);
		}
		return true;
	}

	@Override
	public List<CookBook> findByRestaurantId(Integer Id) {
		List<CookBook> list = cookBookRepository.findByRestauranId(Id);
		return list;
	}

	@Override
	public CookBook save(CookBook cookbook) {
		return cookBookRepository.save(cookbook);
	}

	@Override
	public List<CookBookVo> findByRestaurantAndCookName() {
		List<Object[]> resultList = cookBookRepository.findByRestaurantAndCookName();
		try {
			return ObjectUtil.castEntity(resultList, CookBookVo.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}