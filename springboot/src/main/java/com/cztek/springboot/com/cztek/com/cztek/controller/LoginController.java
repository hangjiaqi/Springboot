package com.cztek.springboot.com.cztek.com.cztek.controller;


import com.cztek.springboot.com.cztek.Enum.DateEunm;
import com.cztek.springboot.com.cztek.com.cztek.Util.DataUtils;
import com.cztek.springboot.com.cztek.com.cztek.service.ICookBookService;
import com.cztek.springboot.com.cztek.com.cztek.service.IRestaurantService;
import com.cztek.springboot.com.cztek.com.cztek.service.IUserBookService;
import com.cztek.springboot.com.cztek.com.cztek.service.IUserService;
import com.cztek.springboot.com.cztek.entity.CookBook;
import com.cztek.springboot.com.cztek.entity.Restaurant;
import com.cztek.springboot.com.cztek.entity.User;
import com.cztek.springboot.com.cztek.entity.UserBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


@Controller
@RequestMapping("/cz")
@Slf4j
public class LoginController {
    @Resource
    private ICookBookService cookBookServiceImpl;
    @Resource
    private IRestaurantService restaurantServiceImpl;
    @Resource
    private IUserService userServceImpl;
    @Resource
    private IUserBookService userBookService;

    @RequestMapping("/login")
    public String login(Model model) {
        List<UserBook> userBookList = userBookService.findByNowFoodDate();
        Map<Integer, CookBook> cookBookMap = new HashMap<>();
        Map<Integer, String> userMap = new HashMap<>();
        Map<Integer, Restaurant> restaurantMap = new HashMap<>();
        for (UserBook userbook : userBookList) {
            User user = userServceImpl.findById(userbook.getUserId());
            CookBook cookBook = cookBookServiceImpl.findById(userbook.getBookId());
            Restaurant restaurant = restaurantServiceImpl.findOne(cookBook.getRestauranId());
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
        User user = userServceImpl.findByName(name);
        List<CookBook> cookBooks = cookBookServiceImpl.finAll();
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
