package com.lhq.boot.demo.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 第一个监听器测试,监听的是我们的ApplicationEvent
 *
 * @author lihuaqing
 * @date 2020-03-30 12:24
 **/
@Order(3)
@Component
public class ForthListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        //是否eventType的当前类或者是父类对象
        return eventType.isAssignableFrom(ApplicationStartedEvent.class);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("第四个监听器，实现的是SmartApplicationListener接口" + event.getSource());
    }
}