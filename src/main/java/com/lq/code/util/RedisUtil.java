package com.lq.code.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by qi_liang on 2018/8/31.
 */
@Component
public class RedisUtil {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     *  指定缓存失效时间
     * @param key 键
     * @param time 时间
     * @return
     */
    public boolean expirce(String key,Long time){
        boolean result = false;
        try {
            if (time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * 根据key 获取过期时间
     * @param key 不能为null
     * @return 时间(秒) 返回0代码永久有效
     */
    public long getExpire(String key){

        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }


    /**
     * 判断key是否在缓存中存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){

       return redisTemplate.hasKey(key);
    }

    /**
     * 通过key删除缓存
     * @param key
     */
    public void del(String ...key){
        if (key!=null&&key.length>0){
            for (String keyStr:key){
                redisTemplate.delete(keyStr);
            }
        }
    }

    /**
     * 通过key获取缓存
     * @param key
     * @return
     */
    public Object get(String key){

        return StringUtil.isNotNull(key)?redisTemplate.opsForValue().get(key):null;
    }

    /**
     *  设置缓存
     * @param key
     * @param value 缓存内容
     * @return
     */
    public void set(String key,Object value){

        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 设置缓存
     * @param key
     * @param value 缓存内容
     * @param time 失效时间（单位：秒）
     */
    public void set(String key,Object value,long time){

        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }
}
