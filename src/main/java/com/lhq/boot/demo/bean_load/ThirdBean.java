package com.lhq.boot.demo.bean_load;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 第三个Bean
 *
 * @author lihuaqing
 * @date 2020-04-01 09:32
 **/
@Data
public class ThirdBean {

    private String name;

    private Integer age;

    ThirdBean() {
        this.name = "liyanchao";
        this.age = 40;
    }

}