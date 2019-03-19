package com.lq.dao;

import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/1.
 */
public interface WechatInfoDao extends BaseDao<WechatInfo> {

    Integer count(WechatInfoVo vo);

    List<WechatInfoVo> findListPage(WechatInfoVo vo);

    WechatInfo getByWechatOpenId(@Param("wechatOpenId") String wechatOpenId);

    WechatInfo getByWechatName(@Param("wechatName") String wechatName);
}
