package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * @Author: qi
 * @Description: 微信公众号-消息回复规则
 * @Date: Create in 9:47 PM 2019/3/16
 *
 */
public class WechatRule extends IdEntity {
    /**
     *  规则名称
     */
    private String ruleName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *  创建用户
     */
    private Long createUserId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新用户
     */
    private Long updateUserId;
    /**
     * 关联微信公众号ID
     */
    private Long wechatInfoId;

    /**
     *  回复类型(全回复，随机回复)
     */
    private Integer replyType ;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Long getWechatInfoId() {
        return wechatInfoId;
    }

    public void setWechatInfoId(Long wechatInfoId) {
        this.wechatInfoId = wechatInfoId;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }
}
