package com.lhq.boot.demo;

import com.lhq.boot.demo.initialize.FirstApplicationContextInitialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.addInitializers(new FirstApplicationContextInitialize());
        springApplication.run(args);
    }

}
