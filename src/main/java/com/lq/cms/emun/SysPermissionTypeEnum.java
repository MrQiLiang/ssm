package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限类型枚举类
 * @author qi
 */
public enum SysPermissionTypeEnum {

    SELECT("SELECT","查询"),
    INSERT("INSERT","新增"),
    UPDATE("UPDATE","更新"),
    DELETE("DELETE","删除")
    ;

    SysPermissionTypeEnum(String value, String desc) {
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

    public static Map<String,String> enumMap=new HashMap<>();

    static{
        for (SysPermissionTypeEnum sysPermissionTypeEnum : SysPermissionTypeEnum.values()){
            enumMap.put(sysPermissionTypeEnum.getValue(), sysPermissionTypeEnum.getDesc());
        }
    }

    public static boolean hasValue(int value){

        return enumMap.containsKey(value);
    }

    public static Map<String, String> getEnumMap(){

        return enumMap;
    }

    public static String getDesc(int value){

        return enumMap.get(value);
    }

}
