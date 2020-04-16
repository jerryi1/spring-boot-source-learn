package com.lhq.boot.demo.java.design.create.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 简单bean
 *
 * @author lihuaqing
 * @date 2020-04-01 18:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleBean {

    private String name;

    private Integer age;
}