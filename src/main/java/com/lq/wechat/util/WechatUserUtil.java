package com.lq.wechat.util;

import com.alibaba.fastjson.JSONObject;
import com.lq.code.util.HttpKit;
import com.lq.entity.WechatUser;

/**
 * @Author: qi
 * @Description: 微信公众号-用户相关的工具类
 * @Date: Create in 4:56 PM 2019/3/17
 */
public class WechatUserUtil {

    /**
     * 获取关注用户列表
     */
    public static final String GET_USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
    /**
     *  获取用户基本信息接口 (get请求)
     */
    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     * 批量获取用户基本信息 (post请求)
     */
    public static final String BATCHGET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";


    public static String getWechatUserStr(String accessToken,String openId){
        String url = GET_USER_INFO_URL.replace("ACCESS_TOKEN",accessToken).replace("OPENID","openId");
        String result = HttpKit.get(url);
        return result;
    };

    /**
     *  获取微信用户资料
     * @param accessToken
     * @param openId
     * @return
     */
    public static WechatUser getWechatUser(String accessToken,String openId){
        String result = getWechatUserStr(accessToken,openId);
        WechatUser wechatUser = JSONObject.parseObject(result,WechatUser.class);
        return wechatUser;
    }

    public static void main(String[] args) {
        String token = "31_uTuXD_IEbECUYQch9JQxyI1qlLMEh-fRefmbjhVAaM0B6cwnGGBbbwZAYLDhKcQhRhZNekxmzO5YkfXWJQsdNmuetuI0lIAF7b6fcf1K_kf9uOyU_zxa7W3evv2cJD5m9fLyT_mr8Fz7laCeISTaAHAUEF";
        String getUrl = GET_USER_LIST_URL.replace("ACCESS_TOKEN",token);
        String result = HttpKit.get(getUrl);
        System.out.println(result);
    }
}
