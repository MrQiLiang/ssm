package com.lq.cms.vo;

/**
 * 角色资源权限视图类
 * @author qi
 * Created by qi_liang on 2018/2/4.
 */
public class SysRoleResourcePermissionVo {

    //角色ID
    private Long roleId;
    //资源ID
    private Long resourceId;
    //权限ID
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
