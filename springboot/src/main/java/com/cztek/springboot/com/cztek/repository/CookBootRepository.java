package com.cztek.springboot.com.cztek.repository;

import com.cztek.springboot.com.cztek.entity.CookBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CookBootRepository extends JpaRepository<CookBook, Integer> {

}
