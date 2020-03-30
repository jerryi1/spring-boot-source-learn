package com.lhq.boot.demo.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 第一个监听器测试,监听的是我们的ApplicationEvent
 *
 * @author lihuaqing
 * @date 2020-03-30 12:24
 **/
@Order(2)
public class SecondListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationEvent) {
        System.out.println("第二个event事件" + applicationEvent.getSource());
    }
}