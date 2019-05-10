package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 6:09 AM 2019/4/28
 */
public enum WechatInfoCertificationTypeEnum {
    CERTIFICATION_YES(1,"认证"),
    CERTIFICATION_NO(0,"未认证")
    ;

    WechatInfoCertificationTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private Integer value;

    private String desc;

    private static Map<Integer,String> enumMap = new HashMap(WechatInfoEncodingTypeEnum.values().length);

    static {
        WechatInfoCertificationTypeEnum[] wechatInfoEncodingTypeEnumArray = WechatInfoCertificationTypeEnum.values();
        for (WechatInfoCertificationTypeEnum wechatInfoCertificationTypeEnum : wechatInfoEncodingTypeEnumArray) {
            enumMap.put(wechatInfoCertificationTypeEnum.value, wechatInfoCertificationTypeEnum.desc);
        }
    }

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

    //判断是否存在值
    public static boolean hasValue(String value){

        return enumMap.containsKey(value);
    }

    public static Map<Integer,String> getEnumMap(){

        return enumMap;
    }

    public static String getDesc(Integer value){

        return enumMap.get(value);
    }
}
