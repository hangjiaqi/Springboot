package com.cztek.springboot.vo;


import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserVo {


    @NotEmpty(message = "名字不能包含空格,必须中文")
    @NotBlank(message = "名字不能为空,必须中文")
    @Length(min = 2, max = 4, message = "名字长度不正确")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
