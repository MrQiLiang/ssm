package com.lq.code.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;

/**
 * @author qi
 */
public class RedisCache implements Cache {


    private RedisTemplate redisTemplate;

    private String name;


    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object key) {
        final String keyf=key.toString();
        Object object;
        //java8 的新语法
        object = redisTemplate.execute((RedisCallback<Object>) connection ->{
            byte [] key1= keyf.getBytes();
            byte [] value= connection.get(key1);
            if(value==null){
                return null;
            }
            return SerializationUtils.deserialize(value);
        });
        return (object!=null?new SimpleValueWrapper(object):null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        final String keyf=key.toString();
        final Object vaulef=value;
        final long liveTime=86400;
        redisTemplate.execute((RedisCallback<Long>) connection -> {
            byte [] keyb=keyf.getBytes();
            byte [] valueb =SerializationUtils.serialize(vaulef);
            connection.set(keyb,valueb);
            if (liveTime>0){
                connection.expire(keyb,liveTime);
            }
            return 1L;
        });
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object key) {
        final String keyf=key.toString();
        redisTemplate.execute((RedisCallback<Long>) connection -> connection.del(keyf.getBytes()));
    }

    @Override
    public void clear() {
        redisTemplate.execute((RedisCallback<String>) connection ->{
           connection.flushDb();
           return "OK";
        });
    }


}
