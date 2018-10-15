package com.lq.cms.vo;

import com.lq.code.util.DateUtil;

import java.util.Date;

/**
 * Created by qi_liang on 2018/2/24.
 */
public class SysLogVo extends BasePageVo {

    private Long id;
    private String userIp;
    private Date createTime;
    private String createTimeStr;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        this.createTimeStr= DateUtil.getDateToStr(createTime);
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
