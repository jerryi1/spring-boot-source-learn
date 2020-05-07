package com.lhq.boot.demo.config_level;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 这个测试是我们项目运行完，获取我们对应的参数
 */
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner, EnvironmentAware {

    private Environment environment;

    @Override
    public void run(String... args) {
        System.out.println("这里是我们的参数" + args);
        System.out.println("参数是：" + environment.getProperty("lhqPwd"));
        System.out.println("下面是随机的参数" + environment.getProperty("randomValue"));
        System.out.println("下面是我们os的系统变量" + environment.getProperty("defaultSystem"));
        System.out.println("这里是我们的jvmName参数" + environment.getProperty("jvmName"));
        //这里是我们获取的参数信息
        System.out.println("这里是我们的SPRING_APPLICATION_JSON对应的参数" + environment.getProperty("name"));
        //下面是我们命令行参数
        System.out.println("下面是我们的命令行参数Command line arguments." + environment.getProperty("commandParam"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
