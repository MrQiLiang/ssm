package com.lq.wechat.util.token;

import com.lq.cms.emun.WechatAccessTokenTypeEnum;
import com.lq.code.util.StringUtil;
import com.lq.entity.WechatAccessToken;
import com.lq.wechat.mode.AccessToken;

import java.util.Date;

/**
 * @Author: qi
 * @Description:token适配器默认实现
 * @Date: Create in 11:16 PM 2019/3/16
 */
public class DefaultAccessTokenAdapter implements AccessTokenAdapter{


    @Override
    public WechatAccessToken adapter(AccessToken accessToken) {
        String accessTokenStr = accessToken.getAccess_token();
        WechatAccessToken wechatAccessToken = new WechatAccessToken();
        if (StringUtil.isNotNull(accessTokenStr)){
            wechatAccessToken.setAccessToken(accessToken.getAccess_token());
            wechatAccessToken.setCreateTime(new Date());
            wechatAccessToken.setExpiresTime(accessToken.getExpires_in());
            wechatAccessToken.setTokenType(WechatAccessTokenTypeEnum.CURRENCY.getValue());

        }
        return wechatAccessToken;
    }
}
