package com.cztek.springboot.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "permission")
    private int permission;

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
