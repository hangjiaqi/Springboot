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
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/czbook")
@Slf4j
public class CookListController {
    @Autowired
    private ICookBookService cookBookService;
    @Autowired
    private IUserBookService userBookService;
    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private IUserService userServce;

    @GetMapping("/user/cook/{username}/{check_val}")
    public ModelAndView userCheck(@PathVariable(value = "username", required = true) Integer name,
                                  @PathVariable(value = "check_val", required = true) Integer num[],
                                  Model model) {
        for (int i = 0; i < num.length; i++) {
            UserBook userBook = new UserBook();
            userBook.setUserId(name);
            userBook.setBookId(num[i]);
            CookBook cookBook = cookBookService.findById(num[i]);
            userBook.setPrice(cookBook.getPrice());
            userBook.setFoodDate(String.valueOf(System.currentTimeMillis() + "" + userBook.getUserId() + "" + userBook.getBookId()));
            userBookService.save(userBook);
        }
        return new ModelAndView("redirect:/czbook/user/cookbook/list");
    }
    @RequestMapping("/user/cookbook/list")
    public String userList(Model model) {
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
        return "listrestaurant";
    }
}
