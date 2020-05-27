package com.lq.cms.service;

import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.service.BaseService;
import com.lq.entity.WechatInfo;

import java.util.List;

/**
 *
 * @author qi
 */
public interface WechatInfoService extends BaseService<WechatInfo> {
    /**
     * 返回统计数据
     * @param vo
     * @return
     */
    Integer count(WechatInfoVo vo);

    /**
     * 带条件分页查询
     * @param vo
     * @return
     */
    List<WechatInfoVo> findListPage(WechatInfoVo vo);

    /**
     *  通过公众号openId查找公众号详情
     * @param wechatOpenId
     * @return
     */
    WechatInfo getByOpenId(String wechatOpenId);
    /**
     * 通过公众号名称查找公众号详情
     */
    WechatInfo getByWechatName(String wechatName);

}
