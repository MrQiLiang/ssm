package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 *  微信公众号配置
 * Created by qi_liang on 2018/5/24.
 */
public class WechatInfo extends IdEntity {

    //公众号opendId
    private String wechatOpenId;
    //公众号名
    private String wechatName;
    //公众号原始appid
    private String appId;
    //公众号appsecret
    private String appSecpet;
    //配置的url
    private String url;
    //token
    private String token;
    //消息加密类型
    private String encodingType;
    //消息加密密钥
    private String encodingAesKey;
    //创建时间
    private Date createTime;
    //最后更新时间
    private Date lastUpdateTime;

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecpet() {
        return appSecpet;
    }

    public void setAppSecpet(String appSecpet) {
        this.appSecpet = appSecpet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
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

}
