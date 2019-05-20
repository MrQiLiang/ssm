package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 权限角色资源关联表
 * Created by qi on 2017-11-29.
 */
public class SysRoleResourcePermission extends IdEntity {

    /**
     * 关联权限id
     */

    private Long permissionId;
    /**
     * 关联资源id
     */

    private Long resourceId;
    /**
     *  关联用户id
     */

    private Long roleId;
    /**
     * 创建时间
     */

    private Date createTime;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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

}
