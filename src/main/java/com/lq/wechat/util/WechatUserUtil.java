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

    public static WechatUser getWechatUser(String accessToken,String openId){
        String result = getWechatUserStr(accessToken,openId);
        WechatUser wechatUser = JSONObject.parseObject(result,WechatUser.class);
        return wechatUser;
    }

    public static void main(String[] args) {


    }
}
