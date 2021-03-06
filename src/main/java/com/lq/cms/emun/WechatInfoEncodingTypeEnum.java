package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/14.
 * @author qi
 */
public enum  WechatInfoEncodingTypeEnum {
    /**
     * 公众号加密方式-明文
     */
    PLAINTEXT("PLAINTEXT","明文"),
    /**
     * 公众号加密方式-混合
     */
    BLEND("BLEND","混合"),
    /**
     * 公众号加密方式-加密
     */
    ENCRYPT("ENCRYPT","加密")
    ;
    private static Map<String,String> enumMap = new HashMap(WechatInfoEncodingTypeEnum.values().length);

    static {
        WechatInfoEncodingTypeEnum[] wechatInfoEncodingTypeEnumArray = WechatInfoEncodingTypeEnum.values();
        for (WechatInfoEncodingTypeEnum wechatInfoEncodingTypeEnum : wechatInfoEncodingTypeEnumArray) {
            enumMap.put(wechatInfoEncodingTypeEnum.value, wechatInfoEncodingTypeEnum.desc);
        }
    }

    private String value;
    private String desc;

    WechatInfoEncodingTypeEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }
    //判断是否存在值
    public static boolean hasValue(String value){

        return enumMap.containsKey(value);
    }

    public static Map<String,String> getEnumMap(){

        return enumMap;
    }

    public static String getDesc(String value){
            return (String) enumMap.get(value);
    }

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

    public static String getDesc(int value){

        return enumMap.get(value);
    }


}
