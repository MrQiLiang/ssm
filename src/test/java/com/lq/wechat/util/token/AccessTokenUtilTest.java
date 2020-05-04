package com.lq.wechat.util.token;

import org.junit.Test;

public class AccessTokenUtilTest {

    @Test
    public void getAccessToken() {

        String result = AccessTokenUtil.getAccessToken("wx759184412abd6599","3197674021ad999f87273ed79a752212");
        System.out.println(result);
    }

    @Test
    public void getAccessToken1() {
    }
}