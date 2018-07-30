package com.cztek.springboot.vo;

import lombok.Data;

@Data
public class CookBookVo {

	private String name;
	private Integer price;
    private String cookname;
    
    
	public CookBookVo() {
		super();
	}


	public CookBookVo(String name, Integer price, String cookname) {
		super();
		this.name = name;
		this.price = price;
		this.cookname = cookname;
	}
}
