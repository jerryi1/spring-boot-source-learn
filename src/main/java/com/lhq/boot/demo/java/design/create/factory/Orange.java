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
public class Orange extends AbstractProduct {
    private String type;

    Orange() {
        this.name = "orange";
        this.number = 1;
        this.type = this.getClass().getSimpleName();
    }
}