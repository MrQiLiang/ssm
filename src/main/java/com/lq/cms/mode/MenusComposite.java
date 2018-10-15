package com.lq.cms.mode;

/** 本目录采用容器模式
 * Created by qi on 2017-11-29.
 */
public abstract class MenusComposite {

    private Long  menuid;

    private String menuname;

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
