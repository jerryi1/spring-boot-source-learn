package com.lhq.boot.demo.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(value = {SimpleCondition.class})
@ConditionalOnClass(name = {"com.lhq.boot.demo.condition.ObjBean"})
public class FirstConfiguration {

    @Bean
    public ObjBean objBean() {
        return new ObjBean();
    }
}
