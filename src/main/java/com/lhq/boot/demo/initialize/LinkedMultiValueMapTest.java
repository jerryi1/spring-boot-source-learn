package com.lhq.boot.demo.initialize;

import org.springframework.util.LinkedMultiValueMap;

/**
 * LinkedMultiValueMap 测试
 *
 * @author lihuaqing
 * @date 2020-03-29 22:38
 **/
public class LinkedMultiValueMapTest {
    public static void main(String[] agrs) {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("a", "a");
        map.add("a", "b");
        System.out.println(map);
    }

}