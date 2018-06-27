package com.cztek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cztek.springboot.entity.CookBook;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CookBootRepository extends JpaRepository<CookBook, Integer> {

}
