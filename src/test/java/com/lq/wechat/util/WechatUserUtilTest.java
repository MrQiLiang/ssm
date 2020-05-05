package com.lq.wechat.util;


import com.lq.BaseTest;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.dao.WechatUserDao;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatUser;
import com.lq.wechat.mode.openid.WechatOpenId;
import com.lq.wechat.mode.openid.WechatOpenIdList;
import com.lq.wechat.util.token.AccessTokenUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * {"total":5,"count":5,"data":{"openid":["oFedx1UuYB7kWFLrihg4ePO-Ag-Y","oFedx1VxcjdsPYK-1WSCIzygAq-c","oFedx1TjO8l84DtuwVfecMCX8W9Y","oFedx1am2qQ9o9aBxZNe49o0X1-U","oFedx1avr2VqLYvjHzAg8TbNlBW8"]},"next_openid":"oFedx1avr2VqLYvjHzAg8TbNlBW8"}
 *
 * {"subscribe":1,"openid":"oFedx1UuYB7kWFLrihg4ePO-Ag-Y","nickname":"空白","sex":1,"language":"zh_CN","city":"佛山","province":"广东","country":"中国","headimgurl":"http:\/\/thirdwx.qlogo.cn\/mmopen\/Q3auHgzwzM4ddWicmSFgickP4xsX9Kd0wXldicCW9hzWicwGsVicwdd5sswgamU50GTAZdJiau3QicgsQr2nPzexc1pIg\/132","subscribe_time":1579243587,"remark":"","groupid":0,"tagid_list":[],"subscribe_scene":"ADD_SCENE_QR_CODE","qr_scene":0,"qr_scene_str":""}
 */
public class WechatUserUtilTest extends BaseTest {

    @Autowired
    private AccessTokenUtil accessTokenUtil;
    @Autowired
    private WechatUserDao wechatUserDao;

    public void testGetWechatUserListStr() {
    }


    @Test
    public void testGetWechatUserList() {
        WechatInfo wechatInfo = new WechatInfo();
        wechatInfo.setAppId("xxxxxxxxxx");
        wechatInfo.setAppSecpet("xxxxxxxxxxxxx");
        wechatInfo.setWechatOpenId("xxxxxxxxxxxx");
        String token = accessTokenUtil.getAccessToken(wechatInfo);
        WechatOpenIdList wechatOpenIdList = WechatUserUtil.getWechatUserList(token,"");
    }



    @Test
    public void testGetWechatUserStr() {
        WechatInfo wechatInfo = new WechatInfo();
        wechatInfo.setAppId("xxxxxxxxxxxx");
        wechatInfo.setAppSecpet("xxxxxxxxxxxxxx");
        wechatInfo.setWechatOpenId("xxxxxxxxxxx");
        String token = accessTokenUtil.getAccessToken(wechatInfo);
        String result = WechatUserUtil.getWechatUserStr(token,"xxxxxxxxxx");
        System.out.println(result);
    }

    @Test
    public void testGetWechatUser() {
        WechatInfo wechatInfo = new WechatInfo();
        wechatInfo.setAppId("xxxxxxxxx");
        wechatInfo.setAppSecpet("xxxxxxxxxxxxxx");
        wechatInfo.setWechatOpenId("xxxxxxxxxx");
        String token = accessTokenUtil.getAccessToken(wechatInfo);
        WechatUser wechatUser = WechatUserUtil.getWechatUser(token,"xxxxxxxxxxx");

    }

    @Test
    public void testSaveWechatUser(){
        WechatInfo wechatInfo = new WechatInfo();
        wechatInfo.setAppId("xxxxxxxx");
        wechatInfo.setAppSecpet("xxxxxxxxxxxx");
        wechatInfo.setWechatOpenId("xxxxxxxxx");
        String token = accessTokenUtil.getAccessToken(wechatInfo);
        WechatOpenIdList wechatOpenIdList = WechatUserUtil.getWechatUserList(token,"");
        WechatOpenId wechatOpenId  = wechatOpenIdList.getData();
        List<String> openIds = wechatOpenId.getOpenid();
        openIds.forEach(openid->{
            WechatUser wechatUser = WechatUserUtil.getWechatUser(token,openid);
            wechatUser.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatUserDao.save(wechatUser);
        });
    }
}