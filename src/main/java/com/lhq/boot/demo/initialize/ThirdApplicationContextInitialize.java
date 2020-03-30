package com.lhq.boot.demo.initialize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统初始化器--采用配置properties的方法
 *
 * @author lihuaqing
 * @date 2020-03-29 22:09
 **/
@Component
@Order(3)
public class ThirdApplicationContextInitialize implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("第三个初始化器");
    }
}