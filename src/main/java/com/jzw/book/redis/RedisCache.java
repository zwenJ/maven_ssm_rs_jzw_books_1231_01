package com.jzw.book.redis;

import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 16:23
 */
@Component
public class RedisCache implements Cache {


//    @Autowired
//    private RedisTemplate redisTemplate;


    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

}
