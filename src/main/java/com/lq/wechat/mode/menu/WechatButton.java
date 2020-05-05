package com.lq.wechat.mode.menu;

/**
 *
 * Created by qi_liang on 2018/6/1.
 */

import java.util.List;

/**
 *  自定义菜单子菜单
 *  @author qi
 */
public class WechatButton {

    /**
     * 二级菜单
     */
    List<WechatButton> sub_button;
    /**
     * 菜单名称
     */
    private String name;
    /**
     *菜单类型
     */
    private String type;
    /**
     * 菜单键值
     */
    private String key;
    /**
     * 菜单跳转url
     */
    private String url;
    /**
     * 返回永久素材
     */
    private String media_id;
    /**
     * 微信小程序id
     */
    private String appid;
    /**
     * 小程序页面路径
     */
    private String pageapth;

    public List<WechatButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<WechatButton> sub_button) {
        this.sub_button = sub_button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPageapth() {
        return pageapth;
    }

    public void setPageapth(String pageapth) {
        this.pageapth = pageapth;
    }
}
