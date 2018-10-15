package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/14.
 */
public enum  WechatInfoEncodingTypeEnum {
    PLAINTEXT("PLAINTEXT","明文"),
    BLEND("BLEND","混合"),
    ENCRYPT("ENCRYPT","加密")
    ;
    private static Map<String,Object> map = new HashMap();

    static {

        WechatInfoEncodingTypeEnum[] wechatInfoEncodingTypeEnumArray = WechatInfoEncodingTypeEnum.values();
        for (WechatInfoEncodingTypeEnum wechatInfoEncodingTypeEnum : wechatInfoEncodingTypeEnumArray) {
            map.put(wechatInfoEncodingTypeEnum.getValue(), wechatInfoEncodingTypeEnum.getDesc());
        }
    }

    private String value;
    private String desc;

    WechatInfoEncodingTypeEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String getDesc(String value){
            return (String) map.get(value);
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



}
