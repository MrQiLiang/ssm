package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatKeyword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 3:29 PM 2019/5/17
 */
public interface WechatKeywordDao extends BaseDao<WechatKeyword>{

    List<WechatKeyword> findByWechatRuleIdAndStatus(@Param("wechatRuleId") Long wehcatRuleId,@Param("status") Integer status);
}
