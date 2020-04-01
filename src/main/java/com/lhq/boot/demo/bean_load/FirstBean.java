package com.lhq.boot.demo.bean_load;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 第一个Bean
 *
 * @author lihuaqing
 * @date 2020-04-01 09:32
 **/
@Component
@Data
public class FirstBean {

    private String name;

    private Integer age;

    FirstBean() {
        this.name = "lhq";
        this.age = 18;
    }

}