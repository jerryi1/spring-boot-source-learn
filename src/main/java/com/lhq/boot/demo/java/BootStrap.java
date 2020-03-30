package com.lhq.boot.demo.java;

import com.lhq.boot.demo.java.listener.*;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 启动类
 *
 * @author lihuaqing
 * @date 2020-03-30 09:38
 **/
public class BootStrap {

    public static void main1(String[] agrs) {
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

    //运行反射的机制，设置对应的listener
    public static void main2(String[] args) {
        WeatherListener snowListener = new SnowListener();
        WeatherListener rainListener = new RainListener();
        WeatherListener[] weatherListeners = new WeatherListener[]{snowListener, rainListener};
        WeatherRunListener weatherRunListener = new WeatherRunListener(weatherListeners);
        weatherRunListener.snow();
    }

    //通过反射的机制，初始化一些函数
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        WeatherListener snowListener = new SnowListener();
        WeatherListener rainListener = new RainListener();
        WeatherListener[] weatherListeners = new WeatherListener[]{snowListener, rainListener};
        String clazzName = "com.lhq.boot.demo.java.listener.WeatherRunListener";
        Class clazz = ClassUtils.forName(clazzName, ClassUtils.getDefaultClassLoader());
        boolean assignable = ClassUtils.isAssignable(WeatherRunListener.class, clazz);
        if (assignable) {
            Class<WeatherListener[]> paramArgs = WeatherListener[].class;
            Constructor declaredConstructor = clazz.getDeclaredConstructor(paramArgs);
            //如果我们把参数转成Object对象，那么构造函数会把当成可变参数的对象。
            WeatherRunListener runListener = (WeatherRunListener) declaredConstructor.newInstance((Object) weatherListeners);
            runListener.snow();
        }
    }

}