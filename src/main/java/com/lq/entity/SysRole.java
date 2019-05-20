package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 角色表
 * Created by qi on 2017-11-29.
 */
public class SysRole extends IdEntity {

    /**
     *  角色名称
     */

    private String roleName;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
