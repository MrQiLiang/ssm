package com.lq.entity;

import com.lq.code.entity.IdEntity;

/**
 *  微信公众号设置表
 * @author qi
 */
public class WechatInfoSetting extends IdEntity {

    /**
     * 微信公众号ID
     */
    private Long wechatInfoId;
    /**
     * 是否回复
     */
    private Integer openReply;
    /**
     * 默认回复类型
     */
    private Integer defaultMessageType;
    /**
     * 关注回复类型
     */
    private Integer followMessageType;

    public Long getWechatInfoId() {
        return wechatInfoId;
    }

    public void setWechatInfoId(Long wechatInfoId) {
        this.wechatInfoId = wechatInfoId;
    }

    public Integer getOpenReply() {
        return openReply;
    }

    public void setOpenReply(Integer openReply) {
        this.openReply = openReply;
    }

    public Integer getDefaultMessageType() {
        return defaultMessageType;
    }

    public void setDefaultMessageType(Integer defaultMessageType) {
        this.defaultMessageType = defaultMessageType;
    }

    public Integer getFollowMessageType() {
        return followMessageType;
    }

    public void setFollowMessageType(Integer followMessageType) {
        this.followMessageType = followMessageType;
    }
}
