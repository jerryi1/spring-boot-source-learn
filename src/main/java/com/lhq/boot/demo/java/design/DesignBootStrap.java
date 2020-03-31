package com.lhq.boot.demo.java.design;

import com.lhq.boot.demo.java.design.create.President;
import com.lhq.boot.demo.java.design.create.Prototype;

import java.util.Arrays;

/**
 * 设计模式的测试启动类
 *
 * @author lihuaqing
 * @date 2020-03-31 11:14
 **/
public class DesignBootStrap {

    //设计模式的学习

    /**
     * 1 能够看懂UML图（类 接口）
     * 类图之间的关系：UML 中的类图有以下几种关系：依赖关系、关联关系、聚合关系、组合关系、泛化关系和实现关系。其中泛化和实现的耦合度相等，它们是最强的
     * 依赖关系：某个类的方法通过局部变量、方法的参数或者对静态方法的调用来访问另一个类（被依赖类）中的某些方法来完成一些职责  ---->
     * 关联关系: 成员变量  <->  ,一般关联关系，聚合关系，组合关系
     * 聚合关系：has-a 例如：大学和老师，大学不存在了，但是老师依然存在   -◇
     * 组合关系：头-嘴巴。头消失，那么嘴巴也就没了。-⧫
     * 泛化关系，实现关系
     */
    public static void main1(String[] args) {
    }

    /**
     * 关于设计模式的设计原则
     * 1 开闭原则：开闭原则的含义是：当应用的需求改变时，在不修改软件实体的源代码或者二进制代码的前提下，可以扩展模块的功能，使其满足新的需求。
     * （抽象约束、封装变化）http://c.biancheng.net/view/1322.html
     * 2 里氏替换原则:里氏替换原则通俗来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
     * 3 依赖倒置原则:依赖倒置原则的目的是通过要面向接口的编程来降低类间的耦合性
     * 4 单一职责原则
     * 5 接口隔离原则：学生成绩管理程序一般包含插入成绩、删除成绩、修改成绩、计算总分、计算均分、打印成绩信息、査询成绩信息等功能，如果将这些功能全部放到一个接口中显然不太合理，正确的做法是将它们分别放在输入模块、统计模块和打印模块等 3 个模块中
     * 6 迪米特法则：
     * 从依赖者的角度来说，只依赖应该依赖的对象。
     * 从被依赖者的角度说，只暴露应该暴露的方法。
     * 7 合成复用原则：合成复用原则（Composite Reuse Principle，CRP）又叫组合/聚合复用原则（Composition/Aggregate Reuse Principle，CARP）
     */
    public static void main2(String[] args) {
    }


    /**
     * 创建型设计模式：
     * 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
     * 原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。
     * 工厂方法（FactoryMethod）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。
     * 抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。
     * 建造者（Builder）模式：将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。
     */
    public static void main3(String[] args) {
//        单例模式的优势和使用场景：
//        前面分析了单例模式的结构与特点，以下是它通常适用的场景的特点。
//        在应用场景中，某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
//        当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
//        当某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。
        President zt1 = President.getInstance();
        zt1.getName();    //输出总统的名字
        President zt2 = President.getInstance();
        zt2.getName();    //输出总统的名字
        if (zt1 == zt2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }

    /**
     * 1 理解什么是浅拷贝，什么是深拷贝。
     * 浅拷贝的拷贝是基本类型，深拷贝的是其他类型
     * 基本类型：byte short int long char float double boolean (但是这些的包装类型也是ok的)
     * 引用类型：CLASS INTERFACE ARRAY NULL-TYPE
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        //原型模式：因为java存在clone()方法，所以原型模式比较好的实现。
        Prototype prototype = new Prototype("lhq");
        prototype.setWorks(Arrays.asList("play", "game"));

        Prototype clone = prototype.clone();
        System.out.println("prototype == clone?" + (clone == prototype));
        System.out.println("prototype.name==clone.name?" + (clone.getName().equals(prototype.getName())));
        prototype.setName("limin");
        System.out.println(prototype);
        System.out.println(clone);


    }


}