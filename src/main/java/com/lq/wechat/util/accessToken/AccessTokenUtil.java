package com.lq.wechat.util.accessToken;

import com.alibaba.fastjson.JSONObject;
import com.lq.code.util.HttpKit;
import com.lq.dao.WechatAccesstokenDao;
import com.lq.entity.WechatAccessToken;
import com.lq.entity.WechatInfo;
import com.lq.wechat.mode.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * Created by qi_liang on 2018/5/31.
 */
@Component
public class AccessTokenUtil {

    /**
     *  微信公众号获取access_token接口
     */
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public final static String APPID ="wx76ca7130852c4baa";

    public final static String APPSECRET = "d87125562b8e60618bc7b3120dfe3583";

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public static String getAccessToken(String appid,String appsecret){
        String url = ACCESS_TOKEN_URL.replace("APPID",appid).replace("APPSECRET",appsecret);
        String resultStr = HttpKit.get(url);
        return resultStr;
    }

    public static AccessToken getAccessToken(WechatInfo wechatInfo){
        AccessToken accessToken = null;
        if (wechatInfo!=null){
            String result = getAccessToken(wechatInfo.getAppId(),wechatInfo.getAppSecpet());
            accessToken = JSONObject.parseObject(result,AccessToken.class);
        }
        return accessToken;
    }

    public static WechatAccessToken accessTokenToWechatAccessToken(WechatInfo wechatInfo,AccessTokenAdapter accessTokenAdapter){

        AccessToken accessToken = getAccessToken(wechatInfo);
        return accessTokenAdapter.adapter(accessToken);
    }

    public static void main(String[] args) {
        String result = getAccessToken(APPID,APPSECRET);
        System.out.println(result);
        AccessToken accessToken = JSONObject.parseObject(result,AccessToken.class);
        System.out.println(accessToken);
    }


}
