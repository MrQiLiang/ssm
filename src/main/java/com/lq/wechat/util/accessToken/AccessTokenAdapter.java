package com.lq.wechat.util.accessToken;

import com.lq.entity.WechatAccessToken;
import com.lq.wechat.mode.AccessToken;

/**
 * @Author: qi
 * @Description: 数据结构适配器
 * @Date: Create in 11:13 PM 2019/3/16
 */
public interface AccessTokenAdapter {

    WechatAccessToken adapter(AccessToken accessToken);
}
