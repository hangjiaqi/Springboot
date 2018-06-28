package com.cztek.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cook_book")
@Data
public class CookBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cook_name")
    private String cookName;

    @Column(name = "price")
    private double price;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "other_price")
    private double otherPrice;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "is_valid")
    private int isValid;

    @Column(name = "create_user")
    private int createUser;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private int updateUser;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "create_time")
    private Date createTime;
}
