package com.lq.dao;

import com.lq.cms.dao.AdminBaseDao;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.entity.WechatMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信模板消息 dao
 * @author qi
 */
public interface WechatMessageDao extends AdminBaseDao<WechatMessage,WechatMessageVo> {
    /**
     *
     * @param wechatMessageVo
     * @return
     */
    List<WechatMessage> findAllByWechatMessageVo(WechatMessageVo wechatMessageVo);

    /**
     *
     * @param ruleId
     * @return
     */
    WechatMessage findByRuleId(@Param("ruleId")Long ruleId);
}
