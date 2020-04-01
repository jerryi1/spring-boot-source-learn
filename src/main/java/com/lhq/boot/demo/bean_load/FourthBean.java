package com.lhq.boot.demo.bean_load;

import lombok.Data;

/**
 * 第四个Bean通过beanDefinitionRegisterPostProcess
 *
 * @author lihuaqing
 * @date 2020-04-01 09:32
 **/
@Data
public class FourthBean {

    private String name;

    private Integer age;

    FourthBean() {
        this.name = "liyanchao";
        this.age = 40;
    }

}