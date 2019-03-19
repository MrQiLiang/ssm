package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 *  微信公众号-规则-关键字
 *  设计理念：微信公众号规则表与关键字表是一对多的关系。这张表等同于规则表的扩展字段，因此该表会直接和规则表发生关联(@Link wechatRuleId)
 */
public class WechatKeyword extends IdEntity {
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 匹配类型
     */
    private String matchinType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 关联的规则表ID
     */
    private Long wechatRuleId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMatchinType() {
        return matchinType;
    }

    public void setMatchinType(String matchinType) {
        this.matchinType = matchinType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getWechatRuleId() {
        return wechatRuleId;
    }

    public void setWechatRuleId(Long wechatRuleId) {
        this.wechatRuleId = wechatRuleId;
    }
}
