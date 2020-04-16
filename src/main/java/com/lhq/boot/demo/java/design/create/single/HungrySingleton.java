package com.lhq.boot.demo.java.design.create.single;

/**
 * 饿汉单例
 *
 * @author lihuaqing
 * @date 2020-03-31 15:36
 **/
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}