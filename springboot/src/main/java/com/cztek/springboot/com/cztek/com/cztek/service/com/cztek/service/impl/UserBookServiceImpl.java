package com.cztek.springboot.com.cztek.com.cztek.service.com.cztek.service.impl;

import com.cztek.springboot.com.cztek.com.cztek.service.IUserBookService;
import com.cztek.springboot.com.cztek.entity.UserBook;
import com.cztek.springboot.com.cztek.repository.UserBookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserBookServiceImpl implements IUserBookService {
    @Resource
    private UserBookRepository userBookRepository;

    @Override
    public UserBook save(UserBook userBook) {
        return userBookRepository.save(userBook);
    }

    @Override
    public List<UserBook> findByNowFoodDate() {
        return userBookRepository.findByNowFoodDate();
    }
}
