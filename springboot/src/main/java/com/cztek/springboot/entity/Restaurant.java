package com.cztek.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 餐厅实体
 */
@Entity
@Table(name = "restaurant")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone_number")
    private String telephoneNumber;

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
