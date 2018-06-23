package com.cztek.springboot.controller;


import com.cztek.springboot.com.cztek.entity.CookBook;
import com.cztek.springboot.com.cztek.entity.Restaurant;
import com.cztek.springboot.com.cztek.entity.User;
import com.cztek.springboot.com.cztek.entity.UserBook;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;
import com.cztek.springboot.service.IUserBookService;
import com.cztek.springboot.service.IUserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Controller
@RequestMapping("/cz")
public class LoginController {
	@Autowired
    private ICookBookService cookBookService;
    @Autowired
    private IUserBookService userBookService;
    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private IUserService userServce;

    @RequestMapping("/login")
    public String login(Model model) {
        List<UserBook> userBookList = userBookService.findByNowFoodDate();
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
        return "login";
    }

    @GetMapping(value = "/login/user/{username}")
    public String loginChek(@PathVariable(value = "username", required = true) String name, Model model) {
        User user = userServce.findByName(name);
        List<CookBook> cookBooks = cookBookService.finAll();
        model.addAttribute("cookBooks", cookBooks);
        if (user != null) {
            model.addAttribute("message", user.getUserId());
            return "list";
        } else {
            model.addAttribute("message", "对不起您输入的名字有误");
            return "login";
        }
    }



}
