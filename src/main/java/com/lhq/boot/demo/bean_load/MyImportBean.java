package com.lhq.boot.demo.bean_load;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 注入importBeanDefinition
 *
 * @author lihuaqing
 * @date 2020-04-01 10:30
 **/
public class MyImportBean implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //这里的importingClassMetadata是什么操作
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(FiveBean.class);
        rootBeanDefinition.setBeanClassName(FiveBean.class.getName());
        registry.registerBeanDefinition("monther", rootBeanDefinition);
    }
}