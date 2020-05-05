package com.lq.wechat.util.token;

import com.lq.BaseTest;
import com.lq.entity.WechatInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccessTokenUtilTest extends BaseTest {

    @Autowired
    private AccessTokenUtil accessTokenUtil;

    @Test
    public void getAccessToken() {
        String result = AccessTokenUtil.getAccessToken("wx76ca7130852c4baa","d87125562b8e60618bc7b3120dfe3583");
        System.out.println(result);
    }

    @Test
    public void getAccessToken1() {
        WechatInfo wechatInfo = new WechatInfo();
        wechatInfo.setAppId("wx76ca7130852c4baa");
        wechatInfo.setAppSecpet("d87125562b8e60618bc7b3120dfe3583");
        wechatInfo.setWechatOpenId("gh_50ba8d7a5efc");
        System.out.println("=================================");
        String token =  accessTokenUtil.getAccessToken(wechatInfo);
        System.out.println("token:"+token);
    }
}