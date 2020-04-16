package com.lhq.boot.demo.databind_validate;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.validation.ValidationUtils;

import java.beans.PropertyEditor;

/**
 * 数据绑定的基本测试
 */
public class DataBindTest {

    /**
     * 基本的数据绑定
     * 提供数据绑定的DataBinder接口
     * 提供数据校验的Validator接口 ValidationUtils
     * MessageCodesResolver 注册错误码  DefaultMessageCodesResolver （这两个可以去了解可以不了解）
     */
    public void start() {

    }

    /**
     * 这里的wrapper是对bean的包装，一般我们都不会单独的使用。
     * 大部分的操作都是在spring factory 或者是dataBind里面进行使用的
     * <p>
     * name	表示 property name，对应于getName()或isName()和setName(..)方法。
     * account.name	指示 property account的嵌套 property name，它对应于(对于 example)getAccount().setName()或getAccount().getName()方法。
     * account[2]	表示索引 property account的第三个元素。索引的 properties 可以是array，list或其他自然排序的集合。
     * account[COMPANYNAME]	表示由account Map property 的COMPANYNAME key 索引的 map 条目的 value。
     * spring 中的Bean | BeanWrapper 和 BeanWrapperImpl
     * 所谓的javaBean在spring文档中的定义：1 无参构造器 2 getter setter
     */
    @Test
    public void wrapper() {
        // 1手动操作（这里用我们的house来进行尝试）
        BeanWrapper company = new BeanWrapperImpl(new Company());
        company.setPropertyValue("name", "ali baba");
        //不同的设置方法
        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);
        //设置一个employee 并且赋值到我们的对象中去
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "lhq");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());
        company.setPropertyValue("managingDirector.salary", 1.00);
        //获取我们的对象
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(salary);
    }

    /**
     * PropertyEditor 实现object和string的转换。
     * 例如：Date可以用人类可读的方式表示(如String：'2007-14-09') 这个是可逆的
     * java.beans.PropertyEditor 可以注册在BeanWrapper内或者是特定的IOC容器中。
     * (1 xml数据绑定 2 spring mvc 映射)
     */
    public void edit() {
        //这个概念是sun公司里面的概念（PropertyEditorManager 对可能需要的editor进行扫描，包括java里面的PropertyEditor，Color等类型的编辑器）
        //这个edit是会被自动发现的
    }


}
