package com.lq.cms.service;

import com.lq.code.service.BaseService;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatUser;

/**
 * @Author: qi
 * @Description: 微信公众号用户事务类
 * @Date: Create in 9:23 AM 2019/3/15
 */
public interface WechatUserService extends BaseService<WechatUser> {
    /**
     *
     * @param openId
     * @return
     */
    WechatUser saveWechatUser(String openId, WechatInfo wechatInfo);
}
