package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 用户表
 * Created by qi on 2017-11-29.
 * @author qi
 */
public class SysUser extends IdEntity {

    /**
     * 登陆名称
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *  更新时间
     */
    private Date updateTime;
    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 头像
     */
    private String imgUrl;
    /**
     * 电子邮件
     */
    private String email;

    public SysUser() {
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
