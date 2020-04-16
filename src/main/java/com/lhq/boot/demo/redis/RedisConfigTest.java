package com.lhq.boot.demo.redis;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

import java.util.Set;

/**
 * 采用配置化的方法来配置redission
 */
public class RedisConfigTest {

    /**
     * {@link Redisson} 我们能看到他们进行的默认配置
     */
    @Test
    public void testConn() {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        //默认采用single+localhost:6379的配置模式
        RedissonClient client = Redisson.create(config);

        RMap<String, String> sex = client.getMap("sex");
        sex.put("男", "1");
        sex.put("女", "0");
        System.out.println(sex.get("男"));
        Set<String> keySet = sex.keySet();
        System.out.println(keySet);
        System.out.println(sex.values());
    }
}
