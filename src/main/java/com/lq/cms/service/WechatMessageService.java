package com.lq.cms.service;

import com.lq.cms.vo.WechatMessageVo;
import com.lq.entity.WechatMessage;

import java.util.List;


public interface WechatMessageService extends AdminBaseService<WechatMessage,WechatMessageVo> {

    List<WechatMessageVo> findAllWechatMessageVo(WechatMessageVo wechatMessageVo);
}
