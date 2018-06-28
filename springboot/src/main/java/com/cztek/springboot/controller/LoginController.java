package com.cztek.springboot.controller;


import com.cztek.springboot.defalut.WebSecurityConfig;
import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.User;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;
import com.cztek.springboot.service.IUserBookService;
import com.cztek.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private ICookBookService cookBookService;
    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private IUserService userServce;
    @Autowired
    private IUserBookService userBookService;

    @RequestMapping
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/addlogin")
    public String loginChek(@ModelAttribute User user, Model model, HttpSession session) {
        user = userServce.login(user);
        if (user != null) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, user.getUserName());
            return "index";
        } else {
            model.addAttribute("message", "对不起您输入的账号密码有误");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.setAttribute(WebSecurityConfig.SESSION_KEY, "");
        return "login";
    }
}
