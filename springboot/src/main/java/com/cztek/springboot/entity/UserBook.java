package com.cztek.springboot.entity;

import com.cztek.springboot.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_book")
@Data
public class UserBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cook_book_id")
    private int cookBookId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "total")
    private double total;

    @Column(name = "food_type")
    private int foodType;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "food_date")
    private Date foodDate;

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

