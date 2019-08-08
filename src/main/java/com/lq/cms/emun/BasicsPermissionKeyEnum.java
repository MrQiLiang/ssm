package com.lq.cms.emun;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 1:25 PM 2019/8/8
 */
public enum BasicsPermissionKeyEnum {

    SELECT_MENU_KEY("SELECT_MENU_KEY","查看菜单"),
    SELECT_DATA_KEY("SELECT_DATA_KEY","查询全部数据"),
    INSERT_KEY("INSERT_KEY","新增数据权限"),
    UPDATE_key("UPDATE_key","更新数据权限"),
    DELETE_KEY("DELETE_KEY","删除数据权限")
    ;

    BasicsPermissionKeyEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private String value;

    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
