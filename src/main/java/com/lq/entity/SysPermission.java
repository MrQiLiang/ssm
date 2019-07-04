package com.lq.entity;

import com.lq.code.entity.IdEntity;

/** 权限表
 * Created by qi on 2017-11-29.
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
    private Integer permissionType;
    /**
     *  权限键值
     */
    private String permissionKey;

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

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }
}
