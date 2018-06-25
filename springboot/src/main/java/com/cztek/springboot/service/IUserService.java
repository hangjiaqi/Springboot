package com.cztek.springboot.service;

import com.cztek.springboot.entity.User;

public interface IUserService {
	 User findByName(String name);
	    User findById(Integer Id);
}
