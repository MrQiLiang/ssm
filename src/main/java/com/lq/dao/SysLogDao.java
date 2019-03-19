package com.lq.dao;

import com.lq.cms.vo.SysLogVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysLog;

import java.util.List;

/**
 * Created by qi on 2017/7/27.
 */
public interface SysLogDao extends BaseDao<SysLog>{

    List<SysLogVo> findListPage(SysLogVo vo);

    Integer count(SysLogVo vo);
}
