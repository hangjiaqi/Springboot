package com.cztek.springboot.repository;

import com.cztek.springboot.entity.Snacks;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:杭佳琦
 * @Desciption: Date:Created in 19:56 2018/9/5
 * @Modified by:
 */
public interface SnacksRepository extends JpaRepository<Snacks, Integer> {

}
