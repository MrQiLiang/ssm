package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qi
 * @Description: 微信公众号类型枚举
 * @Date: Create in 9:44 AM 2019/3/15
 */
public enum WechatInfoTypeEnum {
    /**
     * 公众号类型-订阅号
     */
    SUBSCRIBE(1,"订阅号"),
    /**
     * 公众号类型-服务号
     */
    SERVICE(2,"服务号"),
    /**
     * 公众号类型-企业号
     */
    ENTERPRISE(3,"企业号")
    ;
    WechatInfoTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    private Integer value;

    private String desc;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static Map<Integer,String> enumMap = new HashMap<>(WechatInfoTypeEnum.values().length);

    static {
        WechatInfoTypeEnum[] wechatInfoTypeEnums = WechatInfoTypeEnum.values();
        for (WechatInfoTypeEnum wechatInfoTypeEnum:wechatInfoTypeEnums){
            enumMap.put(wechatInfoTypeEnum.value,wechatInfoTypeEnum.desc);
        }
    }

    public static boolean hasValue(int value){

        return enumMap.containsKey(value);
    }

    public static Map<Integer, String> getEnumMap(){

        return enumMap;
    }

    public static String getDesc(int value){

        return enumMap.get(value);
    }



}
