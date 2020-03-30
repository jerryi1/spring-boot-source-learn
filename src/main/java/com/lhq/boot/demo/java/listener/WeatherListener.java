package com.lhq.boot.demo.java.listener;

/**
 * 天气的监听器
 *
 * @author lihuaqing
 * @date 2020-03-30 10:21
 **/
public interface WeatherListener {

    void doOperate(WeatherEvent weatherEvent);

}