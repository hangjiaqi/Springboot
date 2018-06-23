package com.cztek.springboot.service.impl;

import com.cztek.springboot.com.cztek.entity.UserBook;
import com.cztek.springboot.repository.UserBookRepository;
import com.cztek.springboot.service.IUserBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserBookServiceImpl implements IUserBookService {
	@Autowired
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
