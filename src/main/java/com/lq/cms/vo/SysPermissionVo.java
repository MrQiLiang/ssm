package com.lq.cms.vo;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 11:27 PM 2019/7/22
 */
public class SysPermissionVo extends AdminBaseVo {

    /**
     * 关联资源ID
     */
    private Long sysResourceId;
    /**
     * 关联资源名称
     */
    private String sysResourceName;
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

    public Long getSysResourceId() {
        return sysResourceId;
    }

    public void setSysResourceId(Long sysResourceId) {
        this.sysResourceId = sysResourceId;
    }

    public String getSysResourceName() {
        return sysResourceName;
    }

    public void setSysResourceName(String sysResourceName) {
        this.sysResourceName = sysResourceName;
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
}
