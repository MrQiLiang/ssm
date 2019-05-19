package com.lq.cms.vo;

import java.util.List;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 6:49 AM 2019/5/20
 */
public class WechatMessageBo {

    /**
     *  微信公众号消息总数
     */
    private Integer wechatMessageCount;
    /**
     * 公众号消息
     */
    private List<WechatMessageVo> wechatMessageVoList;

    public Integer getWechatMessageCount() {
        return wechatMessageCount;
    }

    public void setWechatMessageCount(Integer wechatMessageCount) {
        this.wechatMessageCount = wechatMessageCount;
    }

    public List<WechatMessageVo> getWechatMessageVoList() {
        return wechatMessageVoList;
    }

    public void setWechatMessageVoList(List<WechatMessageVo> wechatMessageVoList) {
        this.wechatMessageVoList = wechatMessageVoList;
    }
}
