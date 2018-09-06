package com.cztek.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author:杭佳琦
 * @Desciption: Date:Created in 11:09 2018/8/21
 * @Modified by:
 */
@Entity
@Data
@Table(name = "Snacks")
public class Snacks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;

    private String url;

    private String phone;
}
