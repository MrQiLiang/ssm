package com.lq.entity;

import com.lq.code.entity.IdEntity;

/**
 *  微信公众号设置表
 */
public class WechatInfoSetting extends IdEntity {

    /**
     * 微信公众号ID
     */
    private Long wechatInfoId;


    public Long getWechatInfoId() {
        return wechatInfoId;
    }

    public void setWechatInfoId(Long wechatInfoId) {
        this.wechatInfoId = wechatInfoId;
    }
}
