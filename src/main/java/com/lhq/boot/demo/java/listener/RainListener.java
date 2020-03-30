package com.lhq.boot.demo.java.listener;

/**
 * 下雨的监听器
 *
 * @author lihuaqing
 * @date 2020-03-30 10:21
 **/
public class RainListener implements WeatherListener {
    @Override
    public void doOperate(WeatherEvent weatherEvent) {
        if (weatherEvent instanceof RainEvent) {
            System.out.println(weatherEvent.getName() + "这是下雨，我们可以听听雨声");
        }
    }
}