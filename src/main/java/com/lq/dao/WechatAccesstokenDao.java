package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatAccessToken;

/**
 * 微信公众号 token
 * @author qi
 */
public interface WechatAccesstokenDao extends BaseDao<WechatAccessToken>  {

    WechatAccessToken getByWechatInfoIdAndTokenType(Long wechatInfoId,Integer tokenType);
}
