package com.lhq.boot.demo.java;

import com.lhq.boot.demo.java.listener.*;

/**
 * 启动类
 *
 * @author lihuaqing
 * @date 2020-03-30 09:38
 **/
public class BootStrap {

    public static void main(String[] agrs) {
        WeatherMultiCaster weatherMultiCaster = new WeatherMultiCaster();
        SnowListener snowListener = new SnowListener();
        weatherMultiCaster.addListener(snowListener);
        weatherMultiCaster.publish(new SnowEvent());
        RainListener rainListener = new RainListener();
        weatherMultiCaster.addListener(rainListener);
        weatherMultiCaster.publish(new RainEvent());
        weatherMultiCaster.removeListener(rainListener);
        weatherMultiCaster.publish(new RainEvent());
    }
}