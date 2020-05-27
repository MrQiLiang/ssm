package com.lq.entity;

import com.lq.code.entity.IdEntity;

/**
 * 角色权限关联表
 * @author qi
 */
public class SysRolePermission extends IdEntity {

    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 权限Id
     */
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
