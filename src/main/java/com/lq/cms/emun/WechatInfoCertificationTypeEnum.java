package com.lq.cms.emun;

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


}
