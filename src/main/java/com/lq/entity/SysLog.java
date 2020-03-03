package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 系统日志表
 * Created by qi on 2017/7/27.
 * @author qi
 */
public class SysLog extends IdEntity {
    /**
     * 访问ip
     */
    private  String userIp;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 访问url
     */
    private  String url;

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
