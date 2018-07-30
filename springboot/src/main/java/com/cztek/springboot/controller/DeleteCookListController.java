package com.cztek.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cztek.springboot.Util.DateFormat;
import com.cztek.springboot.service.IUserBookService;
/**
 * @Author:杭佳琦
 * @Description:删除点菜订单Controller
 * @Date: 11:03 2018/7/12
 */
@Controller
@RequestMapping("/delete")
public class DeleteCookListController {

	@Autowired
	private IUserBookService userBookService;

	@PostMapping("/user/book")
	@ResponseBody
	public Map<String,Integer> deleteUserBookId(@RequestParam(value="data") Integer userBookId) {
		Map<String, Integer> map = new HashMap<>();
		String time = DateFormat.currentTime("17:00:00");
		boolean resultInt = DateFormat.resultInt(time);
		if (resultInt) {
		int deleteUserBook = userBookService.deleteUserBook(userBookId);
		map.put("message", deleteUserBook);
		}else{
			map.put("message",-1);
		}
		return map;
	}
}
