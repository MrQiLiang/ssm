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
    /**
     * 创建时间
     */
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
