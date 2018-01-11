package com.jzw.book.redis;

import com.jzw.book.util.DateUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 说明：略
 * @deprecated
 * @author Jzw
 * @date 2018/1/2 16:23
 */
public class RedisCache implements Cache {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(RedisCache.class);
    //redis缓存对象
    private static RedisTemplate redisTemplate;

    //读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //唯一id
    private String id;

    //字节码编码
    private static final String UTF8 = "utf-8";

    //前缀
    private final String PRO_KEYS = "REDIS_BOOKS";

    //后缀
    private String SUB_KEYS = DateUtil.dateToString(new Date());


    public RedisCache (String id) {
        if (null == id) {
            //声明异常
            throw new IllegalArgumentException("主键不能为空！");
        }
        this.id = id;
    }

    /**
     * 按照指定规则生成相关的KEYS
     * @param keys
     * @return
     */
    private String getKey(Object keys){
        StringBuilder sbKey = new StringBuilder();
        sbKey.append(PRO_KEYS);
        sbKey.append(":"+keys+":");
        sbKey.append(SUB_KEYS);
        //TODO 实现
        return sbKey.toString();
    }


    /**
     * 生成ID
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }


    /**
     * 将数据进行缓存
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        logger.debug("正在进行缓存："+redisTemplate);
        if (null != redisTemplate) {
            try {
                //添加缓存
                redisTemplate.opsForValue().set(key, value);
                logger.debug("============\n添加缓存：\n"+key+"\n成功！\n===========");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("数据缓存出现异常", e);
            }
        }
    }


    /**
     * 根据KEYS获取缓存数据
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        logger.debug("正在从缓存中获取数据："+redisTemplate);
        if (null != redisTemplate) {
            try {
                Object objValues = redisTemplate.opsForValue().get(key);
                return objValues;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 根据keys移除缓存的数据
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {

        if (null != redisTemplate) {
            try {
                //return redisTemplate.delete(key);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("removeObject ERROR", e);
            }
        }

        return null;
    }


    /**
     * 清除缓存
     */
    @Override
    public void clear() {

        if (null != redisTemplate) {
            try{
                //根据id获取所有的key
                Set<byte[]> keys = redisTemplate.keys(getId());
                //遍历key集合删除
                for (byte[] key : keys) {
                    redisTemplate.delete(key);
                }
            } catch (Exception e){
                e.printStackTrace();
                logger.error("清空缓存出现错误：\n",e);
            }
        }

    }


    /**
     * 获取缓存实列数量
     * @return
     */
    @Override
    public int getSize() {
        int size = 0;

        if (null != redisTemplate) {

            Set<byte[]> keys = redisTemplate.keys(getId());
            if (null != keys && keys.isEmpty()) {
                size = keys.size();
            }

        }

        return size;
    }


    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }


    public static void setJedisConnectionFactory(RedisTemplate redisTemplate){
        RedisCache.redisTemplate = redisTemplate;
    }
}
