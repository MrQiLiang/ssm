package com.lq.wechat.util;

import com.lq.code.util.HttpKit;
import com.lq.dao.WechatAccesstokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by qi_liang on 2018/5/31.
 */
public class AccessTokenUtil {


    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public final static String APPID ="wx76ca7130852c4baa";

    public final static String APPSECRET = "d87125562b8e60618bc7b3120dfe3583";


    public static String getAccessToken(String appid,String appsecret){
        String url = ACCESS_TOKEN_URL.replace("APPID",appid).replace("APPSECRET",appsecret);
        String resultStr = HttpKit.get(url);
        return resultStr;
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }


}
