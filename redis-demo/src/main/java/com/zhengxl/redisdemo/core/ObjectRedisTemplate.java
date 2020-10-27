package com.zhengxl.redisdemo.core;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @description:
 * @projectName:redis-demo
 * @see:com.zhengxl.redisdemo.config
 * @author:郑晓龙
 * @createTime:2020/10/27 14:34
 * @version:1.0
 */
public class ObjectRedisTemplate extends RedisTemplate<String, Object> {

    public ObjectRedisTemplate(RedisConnectionFactory connectionFactory) {
        setKeySerializer(new StringRedisSerializer());
        setValueSerializer(new GenericJackson2JsonRedisSerializer());
        setHashKeySerializer(new StringRedisSerializer());
        setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        setConnectionFactory(connectionFactory);
    }
}
