package com.lhq.boot.demo.java.design.create.factory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {{desc}
 *
 * @author lihuaqing
 * @date 2020-04-03 16:29
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Apple extends AbstractProduct {
    private String type;

    Apple() {
        this.name = "apple";
        this.number = 100;
        this.type = this.getClass().getSimpleName();
    }
}