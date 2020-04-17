package com.lq.cms.emun;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 11:20 AM 2019/5/11
 */
public enum WechatInfoOpenReplyTypeEnum {
    /**
     * 公众号回复状态-打开
     */
    OPEN_YES(1,"打开"),
    /**
     * 公众号回复状态-关闭
     */
    OPEN_ON(0,"关闭")
    ;
    WechatInfoOpenReplyTypeEnum(Integer value, String desc) {
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
}
