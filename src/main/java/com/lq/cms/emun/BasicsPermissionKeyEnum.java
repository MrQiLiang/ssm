package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 1:25 PM 2019/8/8
 */
public enum BasicsPermissionKeyEnum {

    SELECT_MENU_KEY("SELECT_MENU_KEY","查看菜单","SELECT"),
    SELECT_DATA_KEY("SELECT_DATA_KEY","查询全部数据","SELECT"),
    INSERT_KEY("INSERT_KEY","新增数据","INSERT"),
    UPDATE_key("UPDATE_key","更新数据","UPDATE"),
    DELETE_KEY("DELETE_KEY","删除数据","DELETE")
    ;

    BasicsPermissionKeyEnum(String value, String desc,String type) {
        this.value = value;
        this.desc = desc;
        this.type = type;
    }

    private String value;

    private String desc;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }}
