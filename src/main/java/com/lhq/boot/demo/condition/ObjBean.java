package com.lhq.boot.demo.condition;

import lombok.Data;

@Data
public class ObjBean {

    private Integer hobbit;

    private String sex;

    ObjBean() {
        this.hobbit = 1;
        this.sex = "男";
    }
}
