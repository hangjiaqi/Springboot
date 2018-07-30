package com.cztek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cztek.springboot.entity.UserBook;

import java.util.List;

import javax.transaction.Transactional;

public interface UserBookRepository extends JpaRepository<UserBook, Integer> {
    @Query(value = "SELECT * FROM user_book u where DATE_FORMAT(FROM_UNIXTIME(SUBSTR(u.food_date,1,13)/1000),'%Y-%m-%d') =  DATE_FORMAT(now(),'%Y-%m-%d')", nativeQuery = true)
    List<UserBook> findByNowFoodDate();

    @Query(value = "SELECT * FROM user_book u where DATE_FORMAT(FROM_UNIXTIME(SUBSTR(u.food_date,1,13)/1000),'%Y-%m-%d') =  DATE_FORMAT(now(),'%Y-%m-%d') and u.user_id=:Id", nativeQuery = true)
    List<UserBook> findByUserIdAndFoodDate(@Param("Id") Integer userId);

    @Modifying
    @Transactional
    @Query(value = "delete from user_book where user_book_id=?1", nativeQuery = true)
    int deleteUserBookId(Integer userBookId);

    @Query(value = "select cb.cookname,cb.price,r.name,r.telephone_Number as telephoneNumber,ub.update_time as updateTime,count(cb.cookname) as count from restaurant r LEFT JOIN cook_book cb on r.restaurant_id = cb.restaurant_id LEFT JOIN user_book ub on cb.cook_id = ub.book_id where DATE_FORMAT(ub.update_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d') group by cb.cookname,r.name", nativeQuery = true)
    List<Object[]> findCookBookDay();

    @Query(value = "select * from user_book where user_id=?1", nativeQuery = true)
    List<UserBook> findByUserId(Integer id);

    @Query(value = "select r.name,r.telephone_number,sum(ub.price) as allPrice,DATE_FORMAT(CURDATE(), '%m') as month FROM user_book  ub\n" +
            "LEFT JOIN cook_book cb on ub.book_id=cb.cook_id\n" +
            "LEFT JOIN restaurant r on cb.restaurant_id=r.restaurant_id\n" +
            "where DATE_FORMAT(ub.update_time,'%Y%m') = DATE_FORMAT(CURDATE(), '%Y%m')\n" +
            "group by r.restaurant_id;", nativeQuery = true)
    List<Object[]> findMonthOrder();

    @Query(value = "select count(1) from user_book u where DATE_FORMAT(u.update_time,'%Y-%m-%d') = DATE_FORMAT(CURDATE(),'%Y-%m-%d')",nativeQuery = true)
    int findIntradayOrder();
}
