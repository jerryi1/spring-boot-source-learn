package com.lhq.boot.demo.java.listener;

/**
 * 下雪的event
 *
 * @author lihuaqing
 * @date 2020-03-30 10:20
 **/
public class SnowEvent implements WeatherEvent {

    @Override
    public String getName() {
        return "snow ...";
    }
}