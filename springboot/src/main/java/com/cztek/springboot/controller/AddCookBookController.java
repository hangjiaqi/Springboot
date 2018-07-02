package com.cztek.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cztek.springboot.entity.Message;
import com.cztek.springboot.service.ICookBookService;
import com.cztek.springboot.service.IRestaurantService;


@Controller
@RequestMapping("/add")
public class AddCookBookController {
	
	@Autowired
	ICookBookService cooBookService;
	
	@Autowired
	IRestaurantService restaurantService;

	@RequestMapping("")
	public String addBook(){
		return "addcookbook";
	}
	
	@PostMapping("/cook")
	public String insetBook(@RequestParam("head_txt")MultipartFile file,@RequestParam("repositoryname")String name,@RequestParam("repositorytelephone")String telephone,@RequestParam("sale")String sale,Model model){
		Message msg = restaurantService.checkRestaurantName(file,name,telephone,sale);
		model.addAttribute("message",msg.getMessage());
		return "resultaddck";
	}
}
