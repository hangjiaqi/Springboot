package com.cztek.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.Restaurant;
import com.cztek.springboot.entity.User;
import com.cztek.springboot.entity.UserBook;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;
import com.cztek.springboot.service.IUserBookService;
import com.cztek.springboot.service.IUserService;

@Controller
@RequestMapping("/cz/update")
public class UpdateCookListController {

    @Autowired
    private ICookBookService cookBookService;
    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private IUserService userServce;
    @Autowired
    private IUserBookService userBookService;

    @GetMapping(value = "/login/user/{username}")
    public String loginChek(@PathVariable(value = "username", required = true) String name, Model model) {
        User user = userServce.findByName(name);
        if (user == null) {
            System.out.println("对不起您输入的名字有误");
            model.addAttribute("message", "对不起您输入的名字有误");
            model.addAttribute("username", name);
            return "redirect:/cz/login";
        } else {
            List<UserBook> findByUserId = userBookService.findByUserId(user.getUserId());
            List<UserBook> userBookList = userBookService.findByUserIdAndFoodDate(user.getUserId());
            Map<Integer, CookBook> cookBookMap = new HashMap<>();
            Map<Integer, String> userMap = new HashMap<>();
            Map<Integer, Restaurant> restaurantMap = new HashMap<>();
            for (UserBook userbook : userBookList) {
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
            model.addAttribute("findByUserId", findByUserId);
            return "updatecook";
        }
    }

    @PostMapping("/user/book")
    @ResponseBody
    public Map<String, Integer> deleteUserBookId(@RequestParam(value = "data") Integer userBookId) {
        Map<String, Integer> map = new HashMap<>();
        int deleteUserBook = userBookService.deleteUserBook(userBookId);
        map.put("message", deleteUserBook);
        return map;
    }
}
