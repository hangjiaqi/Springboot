package com.cztek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cztek.springboot.entity.CookBook;
import com.cztek.springboot.entity.CookBookVo;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CookBookRepository extends JpaRepository<CookBook, Integer> {

	List<CookBook> findByRestauranId(Integer Id);
	
	@Query(value="select rt.name,ck.price,ck.cookname from restaurant rt left join cook_book ck on rt.restaurant_id=ck.restaurant_id",nativeQuery=true)
	List<Object[]> findByRestaurantAndCookName();
}
