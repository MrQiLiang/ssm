package com.lq.wechat.mode.template;

/**
 * 消息模版内容
 * Created by qi_liang on 2018/6/27.
 * @author qi
 */
public class WechatTemplateData {
    /**
     * 内容
     */
    private String value;
    /**
     * 字体样式
     */
    private String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
