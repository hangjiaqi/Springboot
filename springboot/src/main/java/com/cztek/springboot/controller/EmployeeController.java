package com.cztek.springboot.controller;

import com.cztek.springboot.entity.User;
import com.cztek.springboot.entity.UserVo;
import com.cztek.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/insert")
public class EmployeeController {

    @Autowired
    private IUserService userService;

    @RequestMapping("")
    public String insertEmployee(UserVo userVo) {
        return "addemployee";
    }

    @PostMapping("/employee")
    public String addEmployee(@Valid UserVo userVo,BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addemployee";
        }
        User user = userService.findByName(userVo.getName());
        if (user == null) {
            user = userService.addUser(userVo.getName());
            model.addAttribute("message", "添加成功");
            return "resultOk";
        }else{
            model.addAttribute("message","用户名已存在");
        }
        return "addemployee";
    }
}
