	package com.cztek.springboot.service.impl;

import com.cztek.springboot.Util.TxtToList;
import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.Message;
import com.cztek.springboot.entity.Restaurant;
import com.cztek.springboot.repository.RestaurantRepository;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private ICookBookService cookBookService;

	@Override
	public Restaurant findOne(int id) {
		return restaurantRepository.findById(id).get();
	}

	@Override
	public Restaurant findByName(String name) {
		Restaurant findByName = restaurantRepository.findByName(name);
		return findByName;
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		Restaurant rt = restaurantRepository.save(restaurant);
		return rt;
	}

	@Override
	public Message checkRestaurantName(MultipartFile file, String name, String telephone, String sale) {
		Message msg = new Message();
		if(!(StringUtils.isBlank(name) && StringUtils.isBlank(telephone)&&file.isEmpty())){
		Restaurant restaurant = this.findByName(StringUtils.trim(name));
		if (restaurant != null) {
			msg = TxtToList.FileToTxt(file, restaurant.getId(), sale);
		} else {
			restaurant = new Restaurant();
			restaurant.setName(name);
			restaurant.setTelephoneNumber(telephone);
			Restaurant save = this.save(restaurant);
			msg = TxtToList.FileToTxt(file, save.getId(), sale);
		}
		if (msg.getCode() == 200) {
			List<CookBook> list = (List) msg.getContent();
			Integer restauranId = restaurant.getId();
			List<CookBook> cklist = cookBookService.findByRestaurantId(restauranId);
			boolean flag = true;
			for (CookBook msglist : list) {
				for (CookBook cookbooklist : cklist) {
					if (msglist.getCookname().equals(cookbooklist.getCookname())&& (!msglist.getPrice().equals(cookbooklist.getPrice()))) {
						cookbooklist.setPrice(msglist.getPrice());
						cookBookService.save(cookbooklist);
						break;
					}
					if (msglist.getCookname().equals(cookbooklist.getCookname())&& (msglist.getPrice().equals(cookbooklist.getPrice()))) {
						flag=false;
						break;
					}else{
						flag=true;
					}
				}
				if(flag){
					cookBookService.save(msglist);
				}
			}
			msg.setMessage("餐单更新成功");
		}
		}else{
			msg.setMessage("餐厅名称与电话不能为空");
			return msg;
		}
		return msg;
	}
}
