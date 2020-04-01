package com.lhq.boot.demo.initialize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统初始化器--采用spring.factories
 *
 * @author lihuaqing
 * @date 2020-03-29 22:09
 **/
@Order(2)
public class SecondApplicationContextInitialize implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("第二个初始化器");
    }
}