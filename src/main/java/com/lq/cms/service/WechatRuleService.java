package com.lq.cms.service;

import com.lq.entity.WechatInfo;
import com.lq.wechat.mode.message.BaseMessage;

/**
 * @Author: qi
 * @Description: 规则事务类
 * @Date: Create in 5:53 AM 2019/5/11
 */
public interface WechatRuleService {

    /**
     *  通过关键字和微信公众号信息返回回复内容
     * @param keyworkd
     * @param wechatInfo
     * @return
     */
    BaseMessage getByKeyworkdAndWechatInfoId(String keyworkd, WechatInfo wechatInfo);
}
