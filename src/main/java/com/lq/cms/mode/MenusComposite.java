package com.lq.cms.mode;

/** 本目录采用容器模式
 *
 * @author qi
 */
public abstract class MenusComposite {
    /**
     * 菜单ID
     */
    private Long  menuid;
    /**
     * 菜单名称
     */
    private String menuname;
    /**
     * 菜单图标
     */
    private String  icon;

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
