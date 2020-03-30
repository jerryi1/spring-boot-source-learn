package com.lhq.boot.demo;

import com.lhq.boot.demo.initialize.FirstApplicationContextInitialize;
import com.lhq.boot.demo.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    /**
     * 1 理解initialize的加载原理和运行机制
     * <p>
     * 2 spring扩展出的linkedMultiValueMap了解
     * <p>
     * 3 AnnotationAwareOrderComparator.sort() 能够进行注解的排序。但是如果我们直接注入list,也是能够根据我们的@Order进行排序的。
     * initializers.sort(new AnnotationAwareOrderComparator());
     * <p>
     * 4 ？？？ 需要增强的技术是spring是如何加载装配资源的。
     * Enumeration<URL> urls = (classLoader != null ?
     * classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
     * ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
     * URL url = urls.nextElement();
     * UrlResource resource = new UrlResource(url);
     * <p>
     * 5 springApplication.addInitializers(new FirstApplicationContextInitialize());这个是做到如何重新排序的
     * 在执行的阶段，里面的getInitializers()这个接口会执行排序。
     */
    public static void main1(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.addInitializers(new FirstApplicationContextInitialize());
        springApplication.run(args);
    }


    //实现监听器的逻辑
    /**
     * 1 ？？？ FirstListener 执行两次的问题，按照道理来说应该是执行一次。但是却执行了两次
     * 发现自己是采用的@Component注解，并且我们在spring.factories 里面进行配置。就会出现两个，应该是spring没有对listener进行去重。或者有其他的区别
     * <p>
     * 2 public native boolean isAssignableFrom(Class<?> cls);
     * class 类中包含isAssignableFrom，能够判断一个class对象是否是另一个class的子类或者是当前类
     * <p>
     * 3 这里的装在流程和initialize相似不在赘述
     * <p>
     * 4 为了减少对springListener发布事件的感知。所以spring对event进行封装
     * SpringApplicationRunListeners listeners = getRunListeners(args);
     * 具体执行的方法还是我们的SpringFactoryLoader的实现，配置文件在我们的spring-boot里面。
     * 需要的传参是applicationConText来获取我们的listener 以及自定义了一个new SimpleApplicationEventMulticaster();
     * 具体的我们可以查看代码
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.addListeners(new SecondListener());
        springApplication.run(args);
    }

}
