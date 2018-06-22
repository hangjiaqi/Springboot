package com.cztek.springboot.com.cztek.entity;

import com.cztek.springboot.Util.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_book")
@DynamicInsert
public class UserBook implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
    private Integer bookId;
    private Integer price;

    private Date updateTime;
    private String foodDate;
    private Integer userBookId;

    public String getFoodDate() {
        return foodDate;
    }

    public void setFoodDate(String foodDate) {
        this.foodDate = foodDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(Integer userBookId) {
        this.userBookId = userBookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Date foodDateFormat;

    @Transient
    public Date getFoodDateFormat() {
        return DataUtils.stringToDateByStamp(this.foodDate.substring(0, 13),DataUtils.DATE_TIME_FORMAT);
    }

    public void setFoodDateFormat(Date foodDateFormat) {
        this.foodDateFormat = foodDateFormat;
    }
}

