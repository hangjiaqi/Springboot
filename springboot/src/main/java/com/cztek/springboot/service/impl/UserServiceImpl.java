package com.cztek.springboot.service.impl;

import com.cztek.springboot.entity.User;
import com.cztek.springboot.repository.UserRepository;
import com.cztek.springboot.service.IUserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        User user = null;
        if (StringUtils.isNotBlank(name)) {
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

    @Override
    public User login(User user) {
        boolean result = validate(user);
        if (result) {
            user = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        } else {
            user = null;
        }
        return user;
    }

    private boolean validate(User user) {
        if (StringUtils.isBlank(user.getUserName())) {
            return false;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            return false;
        }
        return true;
    }
}
