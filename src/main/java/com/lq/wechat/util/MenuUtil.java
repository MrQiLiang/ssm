package com.lq.wechat.util;

import com.alibaba.fastjson.JSON;
import com.lq.code.util.HttpKit;
import com.lq.wechat.mode.menu.WechatButton;
import com.lq.wechat.mode.menu.WechatMenu;
import com.lq.wechat.mode.menu.WechatMenuCofig;

import javax.json.Json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/1.
 */
public class MenuUtil {

    public static final String CREATE_MENU_URL = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

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
     *  查询自定义菜单
     * @param
     */
    public static WechatMenuCofig selectMenu(String accessToken){

        String url = SELECT_MENU_URL.replace("ACCESS_TOKEN",accessToken);

        String resultStr = HttpKit.get(url);

        System.out.println(resultStr);

        WechatMenuCofig wechatMenuCofig =  JSON.parseObject(resultStr,WechatMenuCofig.class);

        System.out.println(wechatMenuCofig.getMenu().getButton().get(0).getName());

        return wechatMenuCofig;
    }

}
