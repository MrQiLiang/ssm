package com.lq.cms.vo;

/**
 * Created by qi_liang on 2018/1/25.
 */
public class PermissionVo {

    //目录ID
    private Long menuId;
    //目录名称
    private String menuName;
    //目录URL
    private String menuUrl;
    //权限名称
    private String permissionName;

    public Long getMenuId() {
        return menuId;
    }

    public PermissionVo setMenuId(Long menuId) {
        this.menuId = menuId;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public PermissionVo setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public PermissionVo setPermissionName(String permissionName) {
        this.permissionName = permissionName;
        return this;
    }
}
