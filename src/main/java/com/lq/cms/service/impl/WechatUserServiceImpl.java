package com.lq.cms.service.impl;

import com.lq.cms.dao.AdminBaseDao;
import com.lq.cms.emun.WechatAccessTokenTypeEnum;
import com.lq.cms.service.WechatUserService;
import com.lq.cms.vo.AdminBaseVo;
import com.lq.cms.vo.WechatUserVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.dao.WechatAccesstokenDao;
import com.lq.dao.WechatUserDao;
import com.lq.entity.WechatAccessToken;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatUser;
import com.lq.wechat.util.accessToken.AccessTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 9:02 PM 2019/3/16
 */
@Service
public class WechatUserServiceImpl extends BaseServiceImpl<WechatUser> implements WechatUserService {

    @Autowired
    private WechatUserDao wechatUserDao;
    @Autowired
    private AccessTokenUtil accessTokenUtil;

    @Override
    public WechatUser saveWechatUser(String openId, WechatInfo wechatInfo) {
        WechatUser wechatUser = wechatUserDao.getByOpenId(openId);
        if (wechatUser==null){
            wechatUser = new WechatUser();
        //    WechatAccessToken wechatAccessToken = wechatAccesstokenDao.getByWechatInfoIdAndTokenType(wechatInfo.getId(), WechatAccessTokenTypeEnum.CURRENCY.getValue());
            String accessToken = accessTokenUtil.getAccessToken(wechatInfo);
            wechatUser.setWechatInfoId(wechatInfo.getId());
            wechatUserDao.save(wechatUser);
        }

        return wechatUser;
    }


    @Override
    public BaseDao<WechatUser> getBaseDao() {

        return wechatUserDao;
    }
}
