package com.zhengxl.redisdemo.redis;

import com.zhengxl.redisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @description:
 * @projectName:redis-demo
 * @see:com.zhengxl.redisdemo.redis
 * @author:郑晓龙
 * @createTime:2020/10/27 14:10
 * @version:1.0
 */
@SpringBootTest
public class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Test
    public void redisTemplateTest(){
        redisTemplate.opsForValue().set("user",new User("zhengxl",10));
    }
}
