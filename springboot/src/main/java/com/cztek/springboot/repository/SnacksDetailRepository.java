package com.cztek.springboot.repository;

import com.cztek.springboot.entity.Snacks;
import com.cztek.springboot.entity.SnacksDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:杭佳琦
 * @Desciption: Date:Created in 19:57 2018/9/5
 * @Modified by:
 */
public interface SnacksDetailRepository extends JpaRepository<SnacksDetail, Integer> {

}
