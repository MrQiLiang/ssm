package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 权限表
 * Created by qi on 2017-11-29.
 * @author qi
 */
public class SysPermission extends IdEntity{

    /**
     * 关联资源ID
     */
    private Long sysResourceId;
    /**
     * 权限名称
     */
    private String name;
    /**
     *  权限类型
     */
    private String permissionType;
    /**
     *  权限键值
     */
    private String permissionKey;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建用户
     */
    private Long createUserId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新用户
     */
    private Long updateUserId;



    public Long getSysResourceId() {
        return sysResourceId;
    }

    public void setSysResourceId(Long sysResourceId) {
        this.sysResourceId = sysResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
}
