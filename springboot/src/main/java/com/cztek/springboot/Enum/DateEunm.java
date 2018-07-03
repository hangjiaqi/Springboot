package com.cztek.springboot.Enum;


public enum DateEunm {

	MONDAY(1, "星期一"), TUESDAY(2, "星期二"), WEDNESDAY(3, "星期三"), THURSDAY(4, "星期四"), FRIDAY(5, "星期五"), SATURDAY(6,
			"星期六"), SUNDAY(0, "星期日"),HEBDOMAD(1234567,"全年无休"),WORKDAY(12345,"工作日");
	private int code;
	private String message;

	DateEunm(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
