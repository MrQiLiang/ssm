package com.lq.dao;

import com.lq.cms.dao.AdminBaseDao;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.entity.WechatMessage;

import java.util.List;

public interface WechatMessageDao extends AdminBaseDao<WechatMessage,WechatMessageVo> {

    List<WechatMessage> findAllByWechatMessageVo(WechatMessageVo wechatMessageVo);
}
