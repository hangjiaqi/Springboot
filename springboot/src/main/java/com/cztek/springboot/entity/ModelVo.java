package com.cztek.springboot.entity;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

@Data
public class ModelVo {

	private String cookname;

	private Integer price;

	private String name;

	private String telephoneNumber;

	private Date updateTime;
	
	private BigInteger count;

	public ModelVo(String cookname, Integer price, String name, String telephoneNumber, Date updateTime,
			BigInteger count) {
		super();
		this.cookname = cookname;
		this.price = price;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.updateTime = updateTime;
		this.count = count;
	}

	public ModelVo() {
		super();
	}
}
