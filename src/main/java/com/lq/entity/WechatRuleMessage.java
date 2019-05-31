package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * @Author: qi
 * @Description:微信公众号消息ID关联表
 * @Date: Create in 4:14 PM 2019/5/30
 */
public class WechatRuleMessage extends IdEntity {

    /**
     *  微信公众号规则ID
     */
    private Long wechatRuleId;
    /**
     * 微信公众号消息ID
     */
    private Long wechatMessageId;

    public Long getWechatRuleId() {
        return wechatRuleId;
    }

    public void setWechatRuleId(Long wechatRuleId) {
        this.wechatRuleId = wechatRuleId;
    }

    public Long getWechatMessageId() {
        return wechatMessageId;
    }

    public void setWechatMessageId(Long wechatMessageId) {
        this.wechatMessageId = wechatMessageId;
    }
}
