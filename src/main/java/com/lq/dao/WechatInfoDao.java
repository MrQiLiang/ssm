package com.lq.dao;

import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信公众号详情 dao
 * @author qi
 */
public interface WechatInfoDao extends BaseDao<WechatInfo> {

    Integer count(WechatInfoVo vo);

    List<WechatInfoVo> findListPage(WechatInfoVo vo);

    WechatInfo getByWechatOpenId(@Param("wechatOpenId") String wechatOpenId);

    WechatInfo getByWechatName(@Param("wechatName") String wechatName);
}
