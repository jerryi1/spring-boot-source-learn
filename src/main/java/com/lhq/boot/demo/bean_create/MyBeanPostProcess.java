package com.lhq.boot.demo.bean_create;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 实现我们自己的beanPostProcessor
 * <p>
 * 代码在控制台打印多次，自己估计这个是对所有类进行同意配置的地方。
 *
 * @author lihuaqing
 * @date 2020-04-01 19:20
 **/
@Component
public class MyBeanPostProcess implements BeanPostProcessor {

    //这里initialization 前的接口
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("这里是MyPostProcessBeforeInitialization");
        return null;
    }

    //这里是initialization 后的接口
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("这里是MyPostProcessAfterInitialization");
        return null;
    }
}