package com.lhq.boot.demo.java.design.create.factory;

import lombok.ToString;

/**
 * 苹果工厂的方法
 *
 * @author lihuaqing
 * @date 2020-04-03 16:28
 **/
public class AppleFactory implements SimpleFactory {

    @Override
    public AbstractProduct createProduct() {
        return new Apple();
    }
}