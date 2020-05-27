package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatRuleMessage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 微信回复规则 dao
 * @author qi
 */
public interface WechatRuleMessageDao extends BaseDao<WechatRuleMessage> {

    WechatRuleMessage getByRuleIdAndMessageId(@Param("ruleId")Long ruleId,@Param("messageId")Long messageId);

    List<WechatRuleMessage> findByWechatRuleId(@Param("wechatRuleId")Long wechatRuleId);

    List<WechatRuleMessage> findByWechatRuleIds(@Param("wechatRuleIds")List<Long> wechatRuleIds);

    void deleteByWechatRuleId(@Param("wechatRuleId")Long wechatRuleId);

}
