package com.lhq.boot.demo.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(value = ObjBean.class)
public class SecondConfiguration {

    @Bean
    public ObjBean objBean() {
        ObjBean objBean = new ObjBean();
        objBean.setSex("unknown");
        return objBean;
    }
}
