package com.lhq.boot.demo.bean_load;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 第一个Bean
 *
 * @author lihuaqing
 * @date 2020-04-01 09:32
 **/
@Data
public class SecondFactoryBean implements FactoryBean {

    @Override
    public Object getObject() {
        return new SecondBean();
    }

    @Override
    public Class<?> getObjectType() {
        return SecondBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}