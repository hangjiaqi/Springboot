package com.cztek.springboot.service.impl;

import com.cztek.springboot.com.cztek.entity.User;
import com.cztek.springboot.repository.UserRepository;
import com.cztek.springboot.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        User user = null;
        if (name != null) {
            user = userRepository.findByName(name);
            if (user == null || !name.equals(user.getName())) {
                user = null;
            }
        }
        return user;
    }

    @Override
    public User findById(Integer Id) {
        User user = userRepository.findById(Id).orElse(null);
        return user;
    }
}
