package com.lq.code.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author qi
 */
public class RedisSessionDao<K,V> extends EnterpriseCacheSessionDAO {


    private final static Logger LOGGER = LoggerFactory.getLogger(RedisSessionDao.class);

    @Autowired
    private RedisTemplate<K,V> redisTemplate;

    private int defaultExpireTime ;

    private CacheManager cm = null;

    public RedisSessionDao(int defaultExpireTime){
        this.defaultExpireTime = defaultExpireTime;
    }


    @Override
    protected void doUpdate(Session session) {
        LOGGER.warn("update shiro sesisonID:"+session.getId().toString());
        //该方法交给父类去执行
     //   super.doUpdate(session);
        //更新reids中的session时间
        redisTemplate.expire((K)session.getId(),this.defaultExpireTime, TimeUnit.SECONDS);

    }

    @Override
    protected void doDelete(Session session) {
        LOGGER.warn("delete shiro sessionID:"+session.getId().toString());
        Serializable sessionId = session.getId();
        cm = CacheManager.create();
        if (cm == null){
            cm = new CacheManager(getCacheMangerConfigFileImputStream());
        }
        Ehcache ehcache = cm.getCache("sessioncache");
        redisTemplate.delete((K) sessionId);
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
        redisTemplate.opsForValue().set((K) sessionId,(V) session);
        redisTemplate.expire((K) sessionId,this.defaultExpireTime, TimeUnit.SECONDS);
        ehcache.put(new Element(sessionId.toString(),session));
        LOGGER.info("create shiro sesisonId:"+sessionId.toString());
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        LOGGER.info("Read shiro sessionID:"+serializable.toString());
        //此方法不会执行,不用管
        Session session = (Session)redisTemplate.opsForValue().get((K) serializable);
        return  session;
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
