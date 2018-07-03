package com.cztek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cztek.springboot.entity.CookBook;

import java.util.List;

@Repository
public interface CookBookRepository extends JpaRepository<CookBook, Integer> {

	List<CookBook> findByRestauranId(Integer Id);

	@Query(value = "select rt.name,ck.price,ck.cookname from restaurant rt left join cook_book ck on rt.restaurant_id=ck.restaurant_id", nativeQuery = true)
	List<Object[]> findByRestaurantAndCookName();

	@Query(value = "select rt.restaurant_id,rt.name,rt.telephone_number,ck.cook_id,ck.cookname,ck.price,ck.sale_price from cook_book ck left join restaurant rt on ck.restaurant_id=rt.restaurant_id where INSTR(rt.work_schedule,:week_day)>0", nativeQuery = true)
	List<Object[]> findWeekCookAndRestaurant(@Param("week_day") String day);
}
