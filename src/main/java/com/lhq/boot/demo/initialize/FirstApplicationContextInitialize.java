package com.lhq.boot.demo.initialize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * 系统初始化器--springApplication注入的方法
 *
 * @author lihuaqing
 * @date 2020-03-29 22:09
 **/
@Component
@Order(1)
public class FirstApplicationContextInitialize implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("第一个初始化器");
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        environment.setRequiredProperties("operate.name");
    }
}