package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

public enum WechatMessageTypeEnum {
    IMAGE("IMAGE","图片"),
    TEXT("TEXT","文本"),
    IMAGE_TEXT("IMAGE_TEXT","图文混合")
    ;

    WechatMessageTypeEnum(String value, String desc) {
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

    private static Map<String,String> enumMap = new HashMap();

    static {
       WechatMessageTypeEnum[] wechantMessageTypeEnums =  WechatMessageTypeEnum.values();
       for (WechatMessageTypeEnum wechantMessageTypeEnum:wechantMessageTypeEnums) {
           enumMap.put(wechantMessageTypeEnum.value, wechantMessageTypeEnum.desc);
       }
    }

    //判断是否存在值
    public static boolean hasValue(String value){

        return enumMap.containsKey(value);
    }

    public static String getDesc(String value){

        return enumMap.get(value);
    }

    public static Map<String,String> getEnumMap(){

        return enumMap;
    }
}
