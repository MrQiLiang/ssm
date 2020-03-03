package com.lq.cms.service.impl;

import com.lq.cms.service.SysLogService;
import com.lq.cms.vo.SysLogVo;
import com.lq.code.dao.BaseDao;
import com.lq.dao.SysLogDao;
import com.lq.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
@Service
public class SysLogServiceImpl  implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public BaseDao<SysLog> getBaseDao() {
        return sysLogDao;
    }

    @Override
    public Integer count(SysLogVo vo) {
        return sysLogDao.count(vo);
    }

    @Override
    public List<SysLogVo> findListPage(SysLogVo vo) {
        return sysLogDao.findListPage(vo);
    }
}
