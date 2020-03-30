package com.lhq.boot.demo.java.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气的广播接口
 *
 * @author lihuaqing
 * @date 2020-03-30 10:25
 **/
public class WeatherMultiCaster {

    /**
     * 监听器的list
     */
    private List<WeatherListener> listeners = new ArrayList<>();

    /**
     * 添加监听器
     */
    public void addListener(WeatherListener listener) {
        this.listeners.add(listener);
    }

    /**
     * 删除监听器
     */
    public void removeListener(WeatherListener weatherListener) {
        this.listeners.remove(weatherListener);
    }

    /**
     * 发布监听
     */
    public void publish(WeatherEvent weatherEvent) {
        listeners.stream().forEach(listener -> {
            listener.doOperate(weatherEvent);
        });
    }


}