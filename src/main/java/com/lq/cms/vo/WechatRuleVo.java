package com.lq.cms.vo;

import com.lq.entity.WechatKeyword;

import java.util.Date;
import java.util.List;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 5:05 PM 2019/5/13
 */
public class WechatRuleVo {
    /**
     * 规则ID
      */
    private Long id;
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

    /**
     * 关键字列表
     */
    private List<WechatKeyword> wechatKeywordList;

    /**
     * 管理消息列表
     */
    private List<Long> messageIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<WechatKeyword> getWechatKeywordList() {
        return wechatKeywordList;
    }

    public void setWechatKeywordList(List<WechatKeyword> wechatKeywordList) {
        this.wechatKeywordList = wechatKeywordList;
    }

    public List<Long> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<Long> messageIds) {
        this.messageIds = messageIds;
    }
}
