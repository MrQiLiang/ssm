package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 *  微信公众号-规则-关键字
 */
public class WechatKeyword extends IdEntity {

    //关键字
    private String keyword;

    //匹配类型
    private String matchinType;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //关联的规则
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
