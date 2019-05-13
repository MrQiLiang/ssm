package com.lq.cms.service.impl;

import com.lq.cms.service.WechatRuleService;
import com.lq.entity.WechatInfo;
import com.lq.wechat.mode.message.BaseMessage;
import org.springframework.stereotype.Service;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 5:55 AM 2019/5/11
 */
@Service
public class WechatRuleServiceImpl implements WechatRuleService {
    @Override
    public BaseMessage getByKeyworkdAndWechatInfoId(String keyworkd, WechatInfo wechatInfo) {
        BaseMessage baseMessage = null;

        return baseMessage;
    }
}
