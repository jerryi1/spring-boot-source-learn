package com.lhq.boot.demo.java.design.create.single;

/**
 * 懒汉式的单例模式
 *
 * @author lihuaqing
 * @date 2020-03-31 15:32
 **/
public class LazySingleton {

    //保证所有的线程都是同步的
    private static volatile LazySingleton instance = null;

    //构造函数私有化
    private LazySingleton() {
    }

    //获取实例对象
    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}