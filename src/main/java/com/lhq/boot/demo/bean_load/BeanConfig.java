package com.lhq.boot.demo.bean_load;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean的配置
 *
 * @author lihuaqing
 * @date 2020-04-01 10:12
 **/
@Configuration
public class BeanConfig {
    @Bean
    public ThirdBean thirdBean(){
        return new ThirdBean();
    }
}