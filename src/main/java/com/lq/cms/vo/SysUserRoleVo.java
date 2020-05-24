package com.lq.cms.vo;

/**
 * 用户角色视图
 * @author qi
 * Created by qi_liang on 2018/2/5.
 */
public class SysUserRoleVo {

    private Long roleId;

    private String  roleName;

    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
