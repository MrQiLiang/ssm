package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * 微信公众号用户
 * Created by qi_liang on 2018/5/24.
 */
public class WechatUser extends IdEntity{

    //用户openId
    private String openId;
    //昵称
    private String nickName;
    //性别
    private Integer sex;
    //语言
    private String language;
    //城市
    private String city;
    //省份
    private String province;
    //国家
    private String country;
    //头像地址
    private String headImgUrl;
    //用户关注时间(多次关注，取最后一次时间)
    private Date subscribeTime;
    //用户对应微信开放平台账号(只有绑定了开放平台账号，才出现该字段)
    private String unionid;
    //运营者对用户备注
    private String remark;
    //用户对应分组
    private String groupid;
    //用户对应的标签
    private String tagidId;
    //用户关注渠道
    private String sybscribeScene;
    //关联的微信ID
    private Long wechatInfoId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getTagidId() {
        return tagidId;
    }

    public void setTagidId(String tagidId) {
        this.tagidId = tagidId;
    }

    public String getSybscribeScene() {
        return sybscribeScene;
    }

    public void setSybscribeScene(String sybscribeScene) {
        this.sybscribeScene = sybscribeScene;
    }

    public Long getWechatInfoId() {
        return wechatInfoId;
    }

    public void setWechatInfoId(Long wechatInfoId) {
        this.wechatInfoId = wechatInfoId;
    }
}
