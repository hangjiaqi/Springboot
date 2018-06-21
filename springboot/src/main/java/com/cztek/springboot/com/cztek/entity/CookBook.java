package com.cztek.springboot.com.cztek.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cook_book")
public class CookBook{


    private Integer id;//主键
    private String cookname;//菜名
    private List<User> userlist;
    private Integer price;//价格
    private Integer salePrice;//优惠价格
    private Restaurant restaurant;
    private Integer restauranId;

    @Column(name = "restaurant_id")
    public Integer getRestauranId() {
        return restauranId;
    }

    public void setRestauranId(Integer restauranId) {
        this.restauranId = restauranId;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id",insertable = false,updatable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "sale_price")
    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cook_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getCookname() {
        return cookname;
    }

    public void setCookname(String cookname) {
        this.cookname = cookname;
    }

    @ManyToMany(mappedBy = "cookBookList")
    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

}
