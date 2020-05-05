package com.lq.wechat.util;


import com.lq.BaseTest;
import com.lq.entity.WechatInfo;
import com.lq.wechat.mode.menu.WechatMenuCofig;
import com.lq.wechat.util.token.AccessTokenUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuUtilTest extends BaseTest {

    @Autowired
    private AccessTokenUtil accessTokenUtil;

    public void testCreateMenu() {

    }

    public void testTestCreateMenu() {
    }

    @Test
    public void testSelectMenu() {
        WechatInfo wechatInfo = new WechatInfo();
        wechatInfo.setAppId("wx76ca7130852c4baa");
        wechatInfo.setAppSecpet("d87125562b8e60618bc7b3120dfe3583");
        wechatInfo.setWechatOpenId("gh_50ba8d7a5efc");
        String token = accessTokenUtil.getAccessToken(wechatInfo);
        WechatMenuCofig wechatMenuCofig = MenuUtil.selectMenu(token);

    }
}