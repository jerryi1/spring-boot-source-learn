package com.lhq.boot.demo.resource;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Enumeration;

/**
 * spring 资源相关的模块开发
 */
@Slf4j
public class ResourceLearn {

    @Test
    public void start() throws IOException {
        //1 对于URL是URI的一种实现，但是多了openConnection 和 openStream功能
        URL url = new URL("http://www.baidu.com");
        URLConnection urlConnection = url.openConnection();

        //java 中加载资源的方式
        //Class 中getResource() 是依赖当前类的资源加载器
        //获取ResourceLoader 实现
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        URL resource = systemClassLoader.getResource("demo.txt");
        log.info("这里是资源的路径:{}", resource.getFile());
        readTxtFile(resource.getFile());

        //能同时获取多个资源
        Enumeration<URL> resources = systemClassLoader.getResources("META-INF/spring.factories");
        while (resources.hasMoreElements()) {
            System.out.println("---------多个文件-----------" + resources.nextElement().getFile());
        }

        //URLClassLoader 是从搜索路径上加载类和资源(这里没有研究出来)
        URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{new URL("file:C:/Users/14488/Desktop/temp/spring-boot-source-learn/src/main/resources/META-INF/")});
        URL factorys = urlClassLoader.findResource("spring.factories");
        System.out.println("根据URLClassLoader加载的资源" + factorys);

        //JarURLConnection     JarFile和JarEntry暂时我们先不考虑
    }

    @Test
    public void use() {
        //UrlResource -->file http ftp
        //ClassPathResource   -->如果在文件系统中可以获取file ,但是如果在jar 或者 不支持的file 请使用UrlResource
        //FileSystemResource  -->表示文件系统
        //ByteArrayResource  --> byte[] 字节数组包装成resource
        //InputStreamResource --> InputStream 包装成resource

        //1 简单资源加载 ResourceLoader
        //这里我们可以添加我们的协议转换器
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        context.addProtocolResolver(new FromHttpProtocolResolver());


        //2 复杂资源加载 ResourcePatternResolver



    }

    public static void readTxtFile(String filePath) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

}
