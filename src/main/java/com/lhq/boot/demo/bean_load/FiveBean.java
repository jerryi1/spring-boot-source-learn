package com.lhq.boot.demo.bean_load;

import lombok.Data;

/**
 * 第五个Bean
 *
 * @author lihuaqing
 * @date 2020-04-01 09:32
 **/
@Data
public class FiveBean {

    private String name;

    private Integer age;

    FiveBean() {
        this.name = "wangqiaoyun";
        this.age = 40;
    }

}