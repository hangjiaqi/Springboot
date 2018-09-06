package com.cztek.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author:杭佳琦
 * @Desciption: Date:Created in 19:34 2018/9/5
 * @Modified by:
 */

@Entity
@Data
@Table(name="SnacksDetail")
public class SnacksDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snacksId", insertable = false, updatable = false)
    private Snacks snacks;
    private int snacksId;
}
