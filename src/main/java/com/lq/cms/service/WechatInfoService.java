package com.lq.cms.service;

import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.service.BaseService;
import com.lq.entity.WechatInfo;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface WechatInfoService extends BaseService<WechatInfo> {

    Integer count(WechatInfoVo vo);

    List<WechatInfoVo> findListPage(WechatInfoVo vo);

    /**
     *  通过公众号openId查找公众号详情
     * @param wechatOpenId
     * @return
     */
    WechatInfo getByOpenId(String wechatOpenId);
}
