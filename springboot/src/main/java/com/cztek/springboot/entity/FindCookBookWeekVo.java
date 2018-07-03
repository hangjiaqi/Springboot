package com.cztek.springboot.entity;

import lombok.Data;

@Data
public class FindCookBookWeekVo {

	private Integer restaurant_id;
	private String name;
	private String telephone_number;
	private Integer cook_id;
	private String cookname;
	private Integer price;
    private Integer sale_price;
    
	public FindCookBookWeekVo() {
		super();
	}

	public FindCookBookWeekVo(Integer restaurant_id, String name, String telephone_number, Integer cook_id,
			String cookname, Integer price, Integer sale_price) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.telephone_number = telephone_number;
		this.cook_id = cook_id;
		this.cookname = cookname;
		this.price = price;
		this.sale_price = sale_price;
	}
}
