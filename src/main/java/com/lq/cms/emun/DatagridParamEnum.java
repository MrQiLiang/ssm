package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

public enum DatagridParamEnum {

    TOTAL("total","数据总数"),
    ROWS("rows","分页数据列")
    ;
    private String value;

    private String desc;

    DatagridParamEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
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
