package com.jzw.book.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 该类针对RedisCache的静态属性JedisConnectionFactory进行依赖注入
 * @author Jzw
 * @data 2017/12/23  9:32
 */
@Component
public class RedisCacheTransfer {

    @Autowired
    public void setJedisConnectionFactory(RedisTemplate redisTemplate) {
        RedisCache.setJedisConnectionFactory(redisTemplate);
    }

}
