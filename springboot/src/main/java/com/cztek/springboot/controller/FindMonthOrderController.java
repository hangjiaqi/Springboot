package com.cztek.springboot.controller;

import com.cztek.springboot.entity.FindMonthOrder;
import com.cztek.springboot.service.IUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class FindMonthOrderController {

    @Autowired
    private IUserBookService userBookService;

    @RequestMapping("")
    public String findMonthOrderAndPrice(Model model){
        List<FindMonthOrder> list=userBookService.findMonthOrder();
        model.addAttribute("listmsg",list);
        return"monthorder";
    }
}
