package com.lq.entity;

import com.lq.code.entity.IdEntity;

/** 权限表
 * Created by qi on 2017-11-29.
 */
public class SysPermission extends IdEntity{

    /**
     * 权限名称
     */
    private String name;
    /**
     *  权限类型
     */
    private int permissionType;
    /**
     *  权限键值
     */
    private String permissionKey;


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
