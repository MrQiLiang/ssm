package com.lq.cms.vo;

import com.lq.code.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by qi_liang on 2018/2/1.
 */
public class SysUserVo extends BasePageVo {

    //ID
    private Long id;
    //登陆名
    private String loginName;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private Integer status;

    private String remarks;

    private String createTimeStr;

    private String updateTimeStr;

    private String lastLoginTimeStr;

    private String email;

    private String imgUrl;
    //关联角色表
    private List<Long> roleList;


    public Long getId() {
        return id;
    }

    public SysUserVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public SysUserVo setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysUserVo setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeStr= DateUtil.getDateToStr(createTime);
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysUserVo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        this.updateTimeStr=DateUtil.getDateToStr(updateTime);
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public SysUserVo setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        this.lastLoginTimeStr =DateUtil.getDateToStr(lastLoginTime);
        return this;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public SysUserVo setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public SysUserVo setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public SysUserVo setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
        return this;
    }

    public String getLastLoginTimeStr() {
        return lastLoginTimeStr;
    }

    public SysUserVo setLastLoginTimeStr(String lastLoginTimeStr) {
        this.lastLoginTimeStr = lastLoginTimeStr;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Long> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Long> roleList) {
        this.roleList = roleList;
    }
}
