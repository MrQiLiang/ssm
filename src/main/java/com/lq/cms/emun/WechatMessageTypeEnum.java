package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * 公众号消息类型
 * @author qi
 */
public enum WechatMessageTypeEnum {
    /**
     * 公众号消息类型-文本
     */
    TEXT(1,"文本"),
    /**
     * 公众号消息类型-图片
     */
    IMAGE(2,"图片"),
    /**
     * 公子号消息类型-图文混合
     */
    IMAGE_TEXT(3,"图文混合")
    ;

    WechatMessageTypeEnum(Integer value, String desc) {
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

    private static Map<Integer,String> enumMap = new HashMap();

    static {
       WechatMessageTypeEnum[] wechantMessageTypeEnums =  WechatMessageTypeEnum.values();
       for (WechatMessageTypeEnum wechantMessageTypeEnum:wechantMessageTypeEnums) {
           enumMap.put(wechantMessageTypeEnum.value, wechantMessageTypeEnum.desc);
       }
    }

    //判断是否存在值
    public static boolean hasValue(Integer value){

        return enumMap.containsKey(value);
    }

    public static String getDesc(Integer value){

        return enumMap.get(value);
    }

    public static Map<Integer,String> getEnumMap(){

        return enumMap;
    }
}
