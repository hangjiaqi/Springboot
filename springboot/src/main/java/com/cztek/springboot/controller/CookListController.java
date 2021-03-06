package com.cztek.springboot.controller;

import com.cztek.springboot.Util.DateFormat;
import com.cztek.springboot.Util.GetWeekDays;
import com.cztek.springboot.entity.*;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;
import com.cztek.springboot.service.IUserBookService;
import com.cztek.springboot.service.IUserService;

import com.cztek.springboot.vo.CookBookVo;
import com.cztek.springboot.vo.FindCookBookWeekVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/czbook")
public class CookListController {
	@Autowired
	private ICookBookService cookBookService;
	@Autowired
	private IUserBookService userBookService;
	@Autowired
	private IRestaurantService restaurantService;
	@Autowired
	private IUserService userServce;

	@RequestMapping("/user/cook")
	public String userCheck(@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "check_val") Integer num[], Model model) {
		model.addAttribute("userId", userId);
		int sugPrice = 0;
		String time = DateFormat.currentTime("17:00:00");
		boolean resultInt = DateFormat.resultInt(time);
		int resultPrice = 0;
		for (int i = 0; i < num.length; i++) {
			CookBook cookBook = cookBookService.findById(num[i]);
			Integer price = cookBook.getPrice();
			sugPrice += price;
		}
		List<UserBook> findByUserIdAndFoodDate = userBookService.findByUserIdAndFoodDate(userId);
		for (UserBook userBook : findByUserIdAndFoodDate) {
			Integer price = userBook.getPrice();
			resultPrice += price;
		}
		Integer sub = sugPrice + resultPrice;
		int max =35;
		if (sugPrice <= max && resultPrice <= max && sub <= max) {
			if (resultInt == true) {
				for (int i = 0; i < num.length; i++) {
					UserBook userBook = new UserBook();
					userBook.setUserId(userId);
					userBook.setBookId(num[i]);
					CookBook cookBook = cookBookService.findById(num[i]);
					userBook.setPrice(cookBook.getPrice());
					userBook.setFoodDate(String.valueOf(
					System.currentTimeMillis() + "" + userBook.getUserId() + "" + userBook.getBookId()));
					userBookService.save(userBook);
				}
				return "redirect:/czbook/user/cook/restaurant/list?userId=" + userId;
			} else {
				model.addAttribute("msg", "已超过5点不能点餐");
			}
		} else {
			model.addAttribute("msg", "当前点餐金额不得超过35元");
		}
		String valueOf =String.valueOf(GetWeekDays.getWeekOfDate(new Date()));
		List<FindCookBookWeekVo> findWeekCook = cookBookService.findWeekCook(valueOf);
		model.addAttribute("cookBooks", findWeekCook);
		return "list";
	}

	@RequestMapping("/user/cook/restaurant/list")
	public String cookList(@RequestParam("userId") Integer userId, Model model) {
		List<UserBook> userBookList = userBookService.findByUserIdAndFoodDate(userId);
		Map<Integer, CookBook> cookBookMap = new HashMap<>();
		Map<Integer, String> userMap = new HashMap<>();
		Map<Integer, Restaurant> restaurantMap = new HashMap<>();
		for (UserBook userbook : userBookList) {
			User user = userServce.findById(userbook.getUserId());
			CookBook cookBook = cookBookService.findById(userbook.getBookId());
			Restaurant restaurant = restaurantService.findOne(cookBook.getRestauranId());
			cookBookMap.put(cookBook.getId(), cookBook);
			restaurantMap.put(restaurant.getId(), restaurant);
			userMap.put(user.getUserId(), user.getName());
		}
		model.addAttribute("userBookList", userBookList);
		model.addAttribute("restaurantMap", restaurantMap);
		model.addAttribute("cookBookMap", cookBookMap);
		model.addAttribute("userMap", userMap);
		return "listrestaurant";
	}
	
	@GetMapping("/find")
	public String cookFandAll(Model model){
		List<CookBookVo> findByRestaurantAndCookName = cookBookService.findByRestaurantAndCookName();
		model.addAttribute("cooklist", findByRestaurantAndCookName);
		return "cooklist";
	}
}