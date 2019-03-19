package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatAccessToken;

/**
 * Created by qi_liang on 2018/6/1.
 */
public interface WechatAccesstokenDao extends BaseDao<WechatAccessToken>  {

    WechatAccessToken getByWechatInfoIdAndTokenType(Long wechatInfoId,Integer tokenType);
}
