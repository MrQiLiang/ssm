package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * 微信公众号-消息
 */
public class WechatMessage extends IdEntity{

    //消息类型
    private String messageType;
    //消息标题
    private String title;
    //消息内容
    private String content;
    //图片路径
    private String imageUrl;
    //素材ID
    private String mediaId;
    //跳转路径
    private String toUrl;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //创建用户
    private Long userId;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
