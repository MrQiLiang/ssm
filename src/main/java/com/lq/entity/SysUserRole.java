package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 用户角色表
 * Created by qi on 2017-11-29.
 */
public class SysUserRole extends IdEntity {

    /**
     * 关联用户id
     */
    private  Long userId;
    /**
     * 管理角色id
     */
    private Long roleId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *  更新时间
     */
    private Date updateTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

}
