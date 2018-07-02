package com.cztek.springboot.controller;

import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.ModelVo;
import com.cztek.springboot.entity.Restaurant;
import com.cztek.springboot.entity.User;
import com.cztek.springboot.entity.UserBook;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;
import com.cztek.springboot.service.IUserBookService;
import com.cztek.springboot.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ICookBookService cookBookService;
	@Autowired
	private IRestaurantService restaurantService;
	@Autowired
	private IUserService userServce;
	@Autowired
	private IUserBookService userBookService;

	@RequestMapping("")
	public String login(Model model) {
		List<UserBook> userBookList = userBookService.findByNowFoodDate();
		List<ModelVo> CookBookDayAll = userBookService.findCookBookDayAll();
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
		model.addAttribute("CookBookDayAll", CookBookDayAll);
		model.addAttribute("userBookList", userBookList);
		model.addAttribute("restaurantMap", restaurantMap);
		model.addAttribute("cookBookMap", cookBookMap);
		model.addAttribute("userMap", userMap);
		return "login";
	}

	@GetMapping(value = "/user/{username}")
	public String loginChek(@PathVariable(value = "username", required = true) String name, Model model) {
		User user = userServce.findByName(name);
		List<CookBook> cookBooks = cookBookService.finAll();
		model.addAttribute("cookBooks", cookBooks);
		if (user != null) {
			model.addAttribute("userId", user.getUserId());
			return "list";
		} else {
			model.addAttribute("message", "对不起您输入的名字有误");
			return login(model);
		}
	}

	@GetMapping(value = "/check")
	public String loginUser() {
		return "checkuser";
	}

}
