package com.lq.cms.emun;

/**
 * @author qi
 * 结果返回结果枚举
 **/
public enum  AjaxResultEnum {

    SUCCESS(200,"操作成功!"),
    WARN(400,"参数不合法!"),
    ERROR(500,"系统异常!")
    ;

    AjaxResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接口状态
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;

}
