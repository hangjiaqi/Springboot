package com.cztek.springboot.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class User {


    private Integer userId;//用户主键
    private String name;//用户名
    private Integer permission;//权限-以便以后对餐单做优化操作
    private List<CookBook> cookBookList; //餐单


    @Column(nullable = false, length = 4)
    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = true)
    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @JoinTable(name = "user_cookbook", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "cook_id", referencedColumnName = "cook_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    public List<CookBook> getCookBookList() {
        return cookBookList;
    }

    public void setCookBookList(List<CookBook> cookBookList) {
        this.cookBookList = cookBookList;
    }
}
