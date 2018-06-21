package com.cztek.springboot.com.cztek.repository;

import com.cztek.springboot.com.cztek.entity.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.Date;
import java.util.List;

public interface UserBookRepository extends JpaRepository<UserBook,Integer> {
    @Query(value = "SELECT * FROM user_book U where DATE_FORMAT(FROM_UNIXTIME(SUBSTR(u.food_date,1,13)/1000),'%Y-%m-%d') =  DATE_FORMAT(now(),'%Y-%m-%d')",nativeQuery = true)
    List<UserBook> findByNowFoodDate();
}
