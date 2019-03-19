package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qi
 * @Description: 微信公众号令牌类型
 * @Date: Create in 10:13 PM 2019/3/16
 */
public enum WechatAccessTokenTypeEnum {
        CURRENCY(1,"普通令牌"),
        PAGE_AUTHORIZATION(2,"页面授权")
        ;

    WechatAccessTokenTypeEnum(Integer value, String desc) {
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

    private static Map<Integer,String> enumMap = new HashMap<>(WechatAccessTokenTypeEnum.values().length);

    static {
        WechatAccessTokenTypeEnum[] wechatAccessTokenTypeEnums = WechatAccessTokenTypeEnum.values();
        for (WechatAccessTokenTypeEnum wechatAccessTokenTypeEnum:wechatAccessTokenTypeEnums){
            enumMap.put(wechatAccessTokenTypeEnum.value,wechatAccessTokenTypeEnum.desc);
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
