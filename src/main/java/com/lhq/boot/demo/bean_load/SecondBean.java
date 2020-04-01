package com.lhq.boot.demo.bean_load;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 第二个Bean
 *
 * @author lihuaqing
 * @date 2020-04-01 09:32
 **/
@Component
@Data
public class SecondBean {

    private String name;

    private Integer age;

    SecondBean() {
        this.name = "limin";
        this.age = 17;
    }

}