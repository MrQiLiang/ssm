package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.entity.WechatUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 5:11 PM 2019/3/14
 */
public interface WechatUserDao extends BaseDao<WechatUser>{

    WechatUser getByOpenId(@Param("openId") String openId);
}
