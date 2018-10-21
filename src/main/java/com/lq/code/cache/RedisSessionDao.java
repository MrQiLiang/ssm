package com.lq.code.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by qi_liang on 2018/9/11.
 */
public class RedisSessionDao extends CachingSessionDAO {

    private final static Logger log = LoggerFactory.getLogger(RedisSessionDao.class);

    private RedisTemplate<String,Object> redisTemplate;

    private int defaultExpireTime ;

    private CacheManager cm = null;

    public RedisSessionDao(RedisTemplate<String,Object> redisTemplate,int defaultExpireTime){
        this.redisTemplate = redisTemplate;
        this.defaultExpireTime = defaultExpireTime;
    }


    @Override
    protected void doUpdate(Session session) {
        //该方法交给父类去执行
    }

    @Override
    protected void doDelete(Session session) {
        Serializable sessionId = session.getId();
        cm = CacheManager.create();
        if (cm == null){
            cm = new CacheManager(getCacheMangerConfigFileImputStream());
        }
        Ehcache ehcache = cm.getCache("sessioncache");
        redisTemplate.delete(sessionId.toString());
        ehcache.remove(sessionId.toString());
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        cm = CacheManager.create();
        if (cm == null){
            cm = new CacheManager(getCacheMangerConfigFileImputStream());
        }

        Ehcache ehcache = cm.getCache("sessioncache");
        assignSessionId(session,sessionId);
        redisTemplate.opsForValue().set(sessionId.toString(),session);
        redisTemplate.expire(session.toString(),this.defaultExpireTime, TimeUnit.SECONDS);
        ehcache.put(new Element(sessionId.toString(),session));
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        //此方法不会执行,不用管
        return null;
    }

    protected InputStream getCacheMangerConfigFileImputStream(){
        String configFile = "classpath:ehcache.xml";
        try {
            return ResourceUtils.getInputStreamForPath(configFile);
        } catch (IOException e) {
           // e.printStackTrace();
            throw new ConfigurationException("Unable to obtain input stram for cacheMangerConfigFile["+configFile+"]",e);
        }
    }
}
