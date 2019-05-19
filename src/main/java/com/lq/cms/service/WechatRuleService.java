package com.lq.cms.service;

import com.lq.cms.vo.WechatRuleVo;
import com.lq.code.service.BaseService;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatKeyword;
import com.lq.entity.WechatRule;
import com.lq.wechat.mode.message.BaseMessage;

import java.util.List;

/**
 * @Author: qi
 * @Description: 规则事务类
 * @Date: Create in 5:53 AM 2019/5/11
 */
public interface WechatRuleService extends BaseService<WechatRule> {

    /**
     *  通过关键字和微信公众号信息返回回复内容
     * @param keyworkd
     * @param wechatInfo
     * @return
     */
    BaseMessage getByKeyworkdAndWechatInfoId(String keyworkd, WechatInfo wechatInfo);
    /**
     * 保存规则和规则对应的关键字
     */
    WechatRule saveRuleAndkeyword(WechatRule wechatRule, List<WechatKeyword> wechatKeywordList);
    /**
     * 保存规则和规则对应的关键字
     */
    WechatRule saveRule(WechatRuleVo wechatRuleVo);

    /**
     * 通过微信公众号详情ID查找关联规则
     * @param wechatInfoId
     * @return
     */
    List<WechatRuleVo> findByWechatInfoId(Long wechatInfoId);
    /**
     * 通过规则ID查找规则详情
     */
    WechatRuleVo getWechatRuleVoById(Long wechatRuleId);
}
