package com.example.wx_1025.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * The type Redis util.redis常用的方法
 *
 * @program: test
 * @description:
 * @author: chenzou
 * @create: 2021 -10-23 08:53
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * Expire boolean   指定缓存失效时间
     *
     * @param key  the key
     * @param time the time
     * @return the boolean
     */
    public boolean expire(String key,long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }


    /**
     * Has key boolean.判断key是否存在
     *
     * @param key the key
     * @return the boolean
     */
    public boolean hasKey(String key){
        try {

            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get string.通过key获取value
     *
     * @param key the key
     * @return the string
     */
    public String get(String key){
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     * Del.删除缓存
     *
     * @param keys the keys
     */
    public void del(String... keys) {
        if (keys != null && keys.length > 0) {

            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);

            }else{
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(keys));
            }
        }
    }

    /**
     * Set boolean.设置一个值
     *
     * @param key    the key
     * @param valule the valule
     */
    public void set(String key, String valule) {
        try {
            redisTemplate.opsForValue().set(key,  valule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Set boolean.放入缓存并设置时间
     *
     * @param key       the key
     * @param value     the value
     * @param timestamp 设置几秒后过期
     * @return the boolean
     */
    public boolean set(String key, String value, long timestamp) {
        try {
            if (timestamp > 0) {
                redisTemplate.opsForValue().set(key,value,timestamp, TimeUnit.SECONDS);
            }else{
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Get all hash map.获取全部的key-value
     *
     * @return the hash map
     */
    public HashMap<Object, Object> getAll(){
        Set<String> keys = redisTemplate.keys("*");
        HashMap<Object, Object> map = new HashMap<>();
        assert keys != null;
        for (String key : keys) {
            String Value = redisTemplate.opsForValue().get(key);
            map.put(key, Value);
        }
        return map;
    }

}
