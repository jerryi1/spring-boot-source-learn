package com.lhq.boot.demo.java.listener;

/**
 * 封装成一个对应的weatherListener
 *
 * @author lihuaqing
 * @date 2020-03-30 14:44
 **/
public class WeatherRunListener {

    private WeatherMultiCaster weatherMultiCaster;

    public WeatherRunListener(WeatherListener[] listeners) {
        this.weatherMultiCaster = new WeatherMultiCaster();
        for (WeatherListener listener : listeners) {
            this.weatherMultiCaster.addListener(listener);
        }
    }

    public void snow() {
        this.weatherMultiCaster.publish(new SnowEvent());
    }

    public void rain() {
        this.weatherMultiCaster.publish(new RainEvent());
    }
}