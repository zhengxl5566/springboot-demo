package com.zhengxl.redisdemo.config;

import com.zhengxl.redisdemo.core.ObjectRedisTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @description:
 * @projectName:redis-demo
 * @see:com.zhengxl.redisdemo.config
 * @author:郑晓龙
 * @createTime:2020/10/27 14:16
 * @version:1.0
 */
@Configuration
public class RedisConfig {
    @Bean
    public ObjectRedisTemplate objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new ObjectRedisTemplate(redisConnectionFactory);
    }
}
