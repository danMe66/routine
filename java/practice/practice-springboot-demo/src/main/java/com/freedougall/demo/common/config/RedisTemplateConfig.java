package com.freedougall.demo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

/**
 * RedisTemplate配置
 */
@Configurable
public class RedisTemplateConfig {
    @Autowired
    public RedisTemplateConfig(RedisTemplate redisTemplate) {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    }
}
