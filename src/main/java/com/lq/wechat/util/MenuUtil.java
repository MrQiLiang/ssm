package com.lq.wechat.util;

import com.alibaba.fastjson.JSON;
import com.lq.code.util.HttpKit;
import com.lq.wechat.mode.menu.WechatMenu;
import com.lq.wechat.mode.menu.WechatMenuCofig;

/**
 *
 * @author qi
 * @date 2018/6/1
 */
public class MenuUtil {
    /**
     * 创建菜单
     */
    public static final String CREATE_MENU_URL = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 查询菜单
     */
    public static final String SELECT_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    /**
     *  创建自定义菜单
     * @param accessToken
     * @param wechatMenu
     * @return
     */
    public static String createMenu(String accessToken,WechatMenu wechatMenu){
        String menuJsonStr = JSON.toJSONString(wechatMenu);
        String resultStr = createMenu(accessToken,menuJsonStr);
        return resultStr;
    }

    public static String createMenu(String accessToken,String wechatMenuStr){
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN",accessToken);
        String resultStr = HttpKit.post(url,wechatMenuStr);
        return resultStr;

    }


    /**
     * 查询自定义菜单
     * @param accessToken
     * @return
     */
    public static String selectMenuStr(String accessToken){
        String url = SELECT_MENU_URL.replace("ACCESS_TOKEN",accessToken);
        String resultStr = HttpKit.get(url);

        return resultStr;
    }

    /**
     *  查询自定义菜单
     * @param
     */
    public static WechatMenuCofig selectMenu(String accessToken){
        String url = SELECT_MENU_URL.replace("ACCESS_TOKEN",accessToken);
        String resultStr = HttpKit.get(url);
        WechatMenuCofig wechatMenuCofig =  JSON.parseObject(resultStr,WechatMenuCofig.class);
        return wechatMenuCofig;
    }

}
