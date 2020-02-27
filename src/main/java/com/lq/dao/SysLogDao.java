package com.lq.dao;

import com.lq.cms.vo.SysLogVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysLog;

import java.util.List;

/**
 * Created by qi on 2017/7/27.
 * @author qi
 * 系统日志类
 */
public interface SysLogDao extends BaseDao<SysLog>{

    /**
     * 参数分页查询
     * @param vo
     * @return
     */
    List<SysLogVo> findListPage(SysLogVo vo);

    /**
     *  参数统计
     * @param vo
     * @return
     */
    Integer count(SysLogVo vo);
}
