package com.lhq.boot.demo.java.design.create.prototype;

import lombok.Data;

import java.util.List;

/**
 * 原型模式的实现
 *
 * @author lihuaqing
 * @date 2020-03-31 17:02
 **/
@Data
public class Prototype implements Cloneable {
    private String name;

    private List<String> works;

    private SimpleBean simpleBean;

    public Prototype(String name) {
        this.name = name;
        this.simpleBean = new SimpleBean("lhq", 12);
        System.out.println("具体原型创建成功！");
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Prototype) super.clone();
    }

}