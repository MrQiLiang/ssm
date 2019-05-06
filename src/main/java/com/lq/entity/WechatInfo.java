package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 *  微信公众号配置
 * Created by qi_liang on 2018/5/24.
 */
public class WechatInfo extends IdEntity {

    /**
     * 公众号opendId
     */
    private String wechatOpenId;
    /**
     * 公众号名
     */
    private String wechatName;
    /**
     * 公众号appid
     */
    private String appId;
    /**
     * 公众号appsecret
     */
    private String appSecpet;
    /**
     * 在微信公众号管理平台配置url
     */
    private String url;
    /**
     * 微信公众号加密token
     */
    private String token;
    /**
     * 消息加密类型
     * @Link WechatInfoEncodingTypeEnum
     */
    private String encodingType;
    /**
     * 消息加密密钥
     */
    private String encodingAesKey;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;
    /**
     *  创建用户ID
     */
    private Long createUserId;
    /**
     *  最后更新用户ID
     */
    private Long updateUserId;
    /**
     *  微信公众号类型
     *  @Link WechatInfoTypeEnum
     */
    private Integer wechatInfoType;
    /**
     * 认证状态
     * 微信公众号在未认证状态下，有部分功能接口受限。
     * @Link WechatInfoCertificationTypeEnum
     */
    private Integer certification;

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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getWechatInfoType() {
        return wechatInfoType;
    }

    public void setWechatInfoType(Integer wechatInfoType) {
        this.wechatInfoType = wechatInfoType;
    }

    public Integer getCertification() {
        return certification;
    }

    public void setCertification(Integer certification) {
        this.certification = certification;
    }
}
