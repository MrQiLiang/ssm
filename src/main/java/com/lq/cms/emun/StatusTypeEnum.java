package com.lq.cms.emun;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by qi_liang on 2018/1/28.
 */
public enum StatusTypeEnum {

    //有效状态
    STATUS_ACTIVITY_YES(1,"有效"),
    //无效状态
    STATUS_ACTIVITY_NO(0,"无效")
    ;

    public static Map<Integer,String> enumMap=new HashMap<>();

    static{
        for (StatusTypeEnum statusTypeEnum : StatusTypeEnum.values()){
            enumMap.put(statusTypeEnum.getValue(), statusTypeEnum.getDesc());
        }
    }

    private Integer value;
    private String desc;

    StatusTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public StatusTypeEnum setValue(Integer value) {
        this.value = value;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc(Integer value){

        return enumMap.get(value);
    }


}
