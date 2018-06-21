package com.cztek.springboot.com.cztek.com.cztek.service;

import com.cztek.springboot.com.cztek.entity.User;

public interface IUserService {
    User findByName(String name);
    User findById(Integer Id);
}
