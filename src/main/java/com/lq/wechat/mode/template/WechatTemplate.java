package com.lq.wechat.mode.template;

import java.util.Map;

/**微信消息模版
 * Created by qi_liang on 2018/6/27.
 *
 *
 参数	是否必填	说明
 touser	是	接收者openid
 template_id	是	模板ID
 url	否	模板跳转链接
 miniprogram	否	跳小程序所需数据，不需跳小程序可不用传该数据
 appid	是	所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
 pagepath	否	所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），暂不支持小游戏
 data	是	模板数据
 color	否	模板内容字体颜色，不填默认为黑色
 */
public class WechatTemplate {
    /**
     * 发送用户openId
     */
    private String touser;
    /**
     * 模版ID
     */
    private String template_id;
    /**
     * 模版跳转链接
     */
    private String url;
    /**
     *  跳转小程序所需数据对象，无需跳转小程序则不用传该数据
     */
    private WechatTemplateMiniprogram miniprogram;
    /**
     * 模版数据
     * key:
     * value:
     */
    private Map<String,Object> data;


    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WechatTemplateMiniprogram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(WechatTemplateMiniprogram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
