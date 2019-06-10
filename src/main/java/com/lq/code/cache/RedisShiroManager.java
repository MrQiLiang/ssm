package com.lq.code.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 10:15 PM 2019/6/8
 */
public class RedisShiroManager implements CacheManager {

    @Autowired
    private RedisShiroCache redisShiroCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {

        return redisShiroCache;
    }
}
