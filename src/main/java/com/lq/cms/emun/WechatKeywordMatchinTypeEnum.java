package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 3:04 PM 2019/5/14
 */
public enum WechatKeywordMatchinTypeEnum {
    /**
     *  微信公众号规则匹配
     */
    KEYWORD_ALL(1,"全匹配"),
    KEYWORD_SECTION(2,"半匹配")
    ;
    WechatKeywordMatchinTypeEnum(Integer value,String desc){
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
        WechatKeywordMatchinTypeEnum[] wechatKeywordMatchinTypeEnums = WechatKeywordMatchinTypeEnum.values();
        for (WechatKeywordMatchinTypeEnum wechatKeywordMatchinTypeEnum:wechatKeywordMatchinTypeEnums){
            enumMap.put(wechatKeywordMatchinTypeEnum.value,wechatKeywordMatchinTypeEnum.desc);
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
