package com.lhq.boot.demo.java.listener;

/**
 * 下雪的监听器
 *
 * @author lihuaqing
 * @date 2020-03-30 10:21
 **/
public class SnowListener implements WeatherListener {

    @Override
    public void doOperate(WeatherEvent weatherEvent) {
        if (weatherEvent instanceof SnowEvent) {
            System.out.println(weatherEvent.getName() + "我们可以堆雪人了");
        }
    }
}