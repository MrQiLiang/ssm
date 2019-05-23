package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * 微信公众号-消息
 * 设计理念：消息是一个独立的事务，因此没有和任何微信公众号关联。
 *          好处：
 *          　1.让后台管理人员可以复用消息，减少重复建立消息
 *          坏处：
 *            1.在此可能衍生的问题可能是无意的修改导致其他公众号的消息也改变。
 *              有牵一发而动全身的风险。
 */
public class WechatMessage extends IdEntity{
    /**
     * 消息类型
     */
    private Integer messageType;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 素材ID
     */
    private String mediaId;
    /**
     *  跳转路径
     */
    private String toUrl;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建用户
     */
    private Long userId;

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
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
