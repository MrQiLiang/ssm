package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 3:58 PM 2019/5/16
 */
public interface WechatRuleDao extends BaseDao<WechatRule>{

    List<WechatRule> findByWechatInfoIdAndStatus(@Param("wechatInfoId") Long wechatInfoId,@Param("status") Integer status);
}
