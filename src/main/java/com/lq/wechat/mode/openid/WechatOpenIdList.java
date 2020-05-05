package com.lq.wechat.mode.openid;

import java.util.List;

/**
 * @Description 微信关注openId列表
 * @Author qi
 **/
public class WechatOpenIdList {
    /**
     * 关注该公众号的总用户数
     */
    private Integer total;
    /**
     * 拉取的openid个数，最大数量为10000
     */
    private Integer count;
    /**
     *  列表数据，openId的列表
     */
    private WechatOpenId data;
    /**
     * 拉取列表的最后一个用户的openId
     */
    private String next_openid;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WechatOpenId getData() {
        return data;
    }

    public void setData(WechatOpenId data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
