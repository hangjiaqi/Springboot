package com.cztek.springboot.com.cztek.com.cztek.service.com.cztek.service.impl;

import com.cztek.springboot.com.cztek.com.cztek.service.IUserService;
import com.cztek.springboot.com.cztek.entity.User;
import com.cztek.springboot.com.cztek.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
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
