package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * 微信公众号-获取accessToken
 * Created by qi_liang on 2018/5/24.
 */
public class WechatAccesstoken extends IdEntity{

    private String accessTokne;

    private Date createTime;

    private Date lastUpdateTime;

    private Long wechatInfoId;

    public String getAccessTokne() {
        return accessTokne;
    }

    public void setAccessTokne(String accessTokne) {
        this.accessTokne = accessTokne;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getWechatInfoId() {
        return wechatInfoId;
    }

    public void setWechatInfoId(Long wechatInfoId) {
        this.wechatInfoId = wechatInfoId;
    }




}
