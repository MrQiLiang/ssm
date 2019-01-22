package com.lq.cms.vo;

import com.lq.cms.emun.WechatMessageTypeEnum;
import com.lq.code.util.DateUtil;

import java.util.Date;

public class WechatMessageVo extends AdminBaseVo{

    //消息类型
    private String messageType;
    //消息类型(中文描述)
    private String messageTypeStr;
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
    //创建用户
    private Long userId;
    //创建时间
    private String createTimeStr;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
        if (WechatMessageTypeEnum.hasValue(messageType)){
            this.messageTypeStr = WechatMessageTypeEnum.getDesc(messageType);
        }
    }

    public String getMessageTypeStr() {
        return messageTypeStr;
    }

    public void setMessageTypeStr(String messageTypeStr) {
        this.messageTypeStr = messageTypeStr;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreateTimeStr() {
        Date createTime = this.getCreateTime();
        if (createTime!=null){
            return DateUtil.getDateToStr(createTime);
        }
        return null;
    }



//    public void setCreateTimeStr(String createTimeStr) {
//        this.createTimeStr = createTimeStr;
//    }
}
