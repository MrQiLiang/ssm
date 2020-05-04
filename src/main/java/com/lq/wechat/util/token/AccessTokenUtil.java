package com.lq.wechat.util.token;

import com.alibaba.fastjson.JSONObject;
import com.lq.code.util.HttpKit;
import com.lq.code.util.StringUtil;
import com.lq.entity.WechatInfo;
import com.lq.wechat.mode.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by qi_liang on 2018/5/31.
 */
@Component
public class AccessTokenUtil {

    /**
     *  微信公众号获取access_token接口
     */
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     *  微信公众号access_token在reids的生命周期时间(单位：秒)
     */
    public final static long DEFAULT_TIME = 7000L;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public static String getAccessToken(String appid,String appsecret){
        String url = ACCESS_TOKEN_URL.replace("APPID",appid).replace("APPSECRET",appsecret);
        String resultStr = HttpKit.get(url);
        return resultStr;
    }

    public String getAccessToken(WechatInfo wechatInfo){

        String accessTokenStr = redisTemplate.opsForValue().get(wechatInfo.getWechatOpenId());
        if (wechatInfo!=null&& StringUtil.isNull(accessTokenStr)){
            String result = getAccessToken(wechatInfo.getAppId(),wechatInfo.getAppSecpet());
            AccessToken accessToken = JSONObject.parseObject(result,AccessToken.class);
            accessTokenStr = accessToken.getAccess_token();
            redisTemplate.opsForValue().set(wechatInfo.getWechatOpenId(),accessTokenStr,DEFAULT_TIME, TimeUnit.SECONDS);
        }
        return accessTokenStr;
    }




}
