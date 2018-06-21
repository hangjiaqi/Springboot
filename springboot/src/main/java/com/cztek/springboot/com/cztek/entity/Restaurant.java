package com.cztek.springboot.com.cztek.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 餐厅实体
 */
@Entity
public class Restaurant {

    private Integer id;//餐厅主键
    private String name;//餐厅名称
    private String telephoneNumber;//餐厅电话

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    private List<CookBook> cookBookList;//菜单
    private Set<CookBook> cookBookSet;//菜单

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestaurantId")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "restaurant",fetch = FetchType.EAGER)
    public List<CookBook> getCookBookList() {
        return cookBookList;
    }

    public void setCookBookList(List<CookBook> cookBookList) {
        this.cookBookList = cookBookList;
    }

}
