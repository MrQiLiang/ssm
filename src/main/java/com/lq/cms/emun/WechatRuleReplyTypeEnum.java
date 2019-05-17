package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 3:14 PM 2019/5/16
 */
public enum  WechatRuleReplyTypeEnum {
    REPLY_ALL(1,"全回复"),
    REPLY_RANDOM(2,"随机回复")
    ;

    WechatRuleReplyTypeEnum(Integer value, String desc) {
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
        WechatRuleReplyTypeEnum[] wechatRuleReplyTypeEnums =  WechatRuleReplyTypeEnum.values();
        for (WechatRuleReplyTypeEnum wechatRuleReplyTypeEnum:wechatRuleReplyTypeEnums) {
            enumMap.put(wechatRuleReplyTypeEnum.value, wechatRuleReplyTypeEnum.desc);
        }
    }

    //判断是否存在值
    public static boolean hasValue(String value){

        return enumMap.containsKey(value);
    }

    public static String getDesc(Integer value){

        return enumMap.get(value);
    }

    public static Map<Integer,String> getEnumMap(){

        return enumMap;
    }
}
