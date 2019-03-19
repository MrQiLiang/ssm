package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qi_liang on 2018/2/3.
 */
public enum  PermissionTyepEnum {

    SELECT(1L,"查询","SELECT"),
    INSERT(2L,"新增","INSERT"),
    DELETE(3L,"删除","DELETE"),
    UPDATE(4L,"更新","UPDATE")
    ;

    public static Map<Integer,String> map=new HashMap<>();

    static{
        for (StatusTypeEnum statusTypeEnum : StatusTypeEnum.values()){
            map.put(statusTypeEnum.getValue(), statusTypeEnum.getDesc());
        }
    }

    private Long value;
    private String desc;
    private String constant;

    PermissionTyepEnum(Long value, String desc,String constant) {
        this.value = value;
        this.desc = desc;
        this.constant = constant;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getDesc(Integer value){

        return map.get(value);
    }

}
