package com.cztek.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cztek.springboot.service.IUserBookService;

@Controller
@RequestMapping("/cz/delete")
public class DeleteCookListController {

	@Autowired
	private IUserBookService userBookService;

	@PostMapping("/user/book")
	@ResponseBody
	public Map<String,Integer> deleteUserBookId(@RequestParam(value="data") Integer userBookId) {
		Map<String, Integer> map = new HashMap<>();
	    int deleteUserBook = userBookService.deleteUserBook(userBookId);
		map.put("message",deleteUserBook);
		return map;
	}
}
