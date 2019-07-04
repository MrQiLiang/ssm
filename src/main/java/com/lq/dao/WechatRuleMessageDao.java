package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatMessage;
import com.lq.entity.WechatRuleMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatRuleMessageDao extends BaseDao<WechatRuleMessage> {

    WechatRuleMessage getByRuleIdAndMessageId(@Param("ruleId")Long ruleId,@Param("messageId")Long messageId);

    List<WechatRuleMessage> findByWechatRuleId(@Param("wechatRuleId")Long wechatRuleId);

}
