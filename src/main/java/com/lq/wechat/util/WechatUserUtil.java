package com.lq.wechat.util;

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
}
