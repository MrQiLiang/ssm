package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * 微信公众号-获取accessToken
 * Created by qi_liang on 2018/5/24.
 * @author qi
 */
public class WechatAccessToken extends IdEntity{
    /**
     *  微信公众号access_token
     */
    private String accessToken;
    /**
     *  创建时间
     */
    private Date createTime;
    /**
     *  到期时间(单位：秒)
     */
    private Long expiresTime;
    /**
     * @Link WechatAccessTokenTypeEnum
     * token 类型(常用，页面授权)
     */
    private Integer tokenType;
    /**
     *  关联的微信公众号ID
     */
    private Long wechatInfoId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(Long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public Integer getTokenType() {
        return tokenType;
    }

    public void setTokenType(Integer tokenType) {
        this.tokenType = tokenType;
    }

    public Long getWechatInfoId() {
        return wechatInfoId;
    }

    public void setWechatInfoId(Long wechatInfoId) {
        this.wechatInfoId = wechatInfoId;
    }

}
