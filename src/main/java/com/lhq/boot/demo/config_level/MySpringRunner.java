package com.lhq.boot.demo.config_level;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 自定义实现我们的runner接口
 */
@Component
@Order(1)
public class MySpringRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        System.out.println("这是我们的占位符" + Arrays.toString(args.getSourceArgs()));
    }
}
