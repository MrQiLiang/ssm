package com.lq.cms.emun;

/**
 * 管理后台数据
 * @author qi
 */
public enum DatagridParamEnum {
    /**
     *  数据总数
     */
    TOTAL("total","数据总数"),
    /**
     * 分页列数
     */
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
