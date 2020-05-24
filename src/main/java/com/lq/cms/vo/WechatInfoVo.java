package com.lq.cms.vo;

import com.lq.cms.emun.WechatInfoCertificationTypeEnum;
import com.lq.cms.emun.WechatInfoEncodingTypeEnum;
import com.lq.cms.emun.WechatInfoTypeEnum;
import com.lq.code.util.DateUtil;

import java.util.Date;

/**
 * 微信公众号详情视图
 * @author qi
 */
public class WechatInfoVo extends BasePageVo {

    private Long id;

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
    //消息加密类型说明
    private String encodingTypeStr;
    //消息加密密钥
    private String encodingAesKey;
    //创建时间
    private Date createTime;
    //创建时间字符串
    private String createTimeStr;
    //最后更新时间
    private Date lastUpdateTime;
    //状态
    private Integer status;
    //公众号类型
    private Integer wechatInfoType;
    //公众号类型（字符串）
    private String wechatInfoTypeStr;
    //公众号认证状态
    private Integer certification;
    //公众号认证状态(字符串)
    private String certificationStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        this.encodingTypeStr = WechatInfoEncodingTypeEnum.getDesc(encodingType);
    }

    public String getEncodingTypeStr() {
        return encodingTypeStr;
    }

    public void setEncodingTypeStr(String encodingTypeStr) {
        this.encodingTypeStr = encodingTypeStr;
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
        if (createTime!=null) {
            this.createTimeStr = DateUtil.getDateToStr(createTime);
        }
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWechatInfoType() {
        return wechatInfoType;
    }

    public void setWechatInfoType(Integer wechatInfoType) {
        this.wechatInfoType = wechatInfoType;
        if (wechatInfoType!=null) {
            this.wechatInfoTypeStr = WechatInfoTypeEnum.getDesc(wechatInfoType);
        }
    }

    public String getWechatInfoTypeStr() {
        return wechatInfoTypeStr;
    }

    public void setWechatInfoTypeStr(String wechatInfoTypeStr) {
        this.wechatInfoTypeStr = wechatInfoTypeStr;
    }

    public Integer getCertification() {
        return certification;
    }

    public void setCertification(Integer certification) {
        this.certification = certification;
        if (certification!=null){
            this.certificationStr = WechatInfoCertificationTypeEnum.getDesc(certification);
        }
    }

    public String getCertificationStr() {
        return certificationStr;
    }

    public void setCertificationStr(String certificationStr) {
        this.certificationStr = certificationStr;
    }
}
