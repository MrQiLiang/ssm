package com.lq.dao;

import com.lq.cms.dao.AdminBaseDao;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatMessage;

import java.util.List;

public interface WechatMessageDao extends AdminBaseDao<WechatMessage> {

    List<WechatMessageVo> findListPage(WechatMessageVo vo);

    int count(WechatMessageVo vo);
}
