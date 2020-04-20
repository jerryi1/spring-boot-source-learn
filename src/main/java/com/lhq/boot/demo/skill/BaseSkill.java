package com.lhq.boot.demo.skill;

import org.junit.Test;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.Assert;

/**
 * 这里是查看spring源码的学到的一些技巧
 */
public class BaseSkill {

    //1 类的泛型解析，和泛型判断
    @Test
    public void t1() {
        Class<?> requiredType = GenericTypeResolver.resolveTypeArgument(MousePerson.class,
                BasePerson.class);
        //这里的Mouse需要是requiredType或者子类（不要弄反）
        Assert.isInstanceOf(requiredType, new Mouse(), "Unable to call initializer.");
    }
}
