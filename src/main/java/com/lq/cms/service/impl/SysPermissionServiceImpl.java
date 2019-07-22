package com.lq.cms.service.impl;

import com.lq.cms.service.SysPermissionService;
import com.lq.cms.vo.SysPermissionVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.dao.SysPermissionDao;
import com.lq.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 12:06 AM 2019/7/23
 */
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermission> implements SysPermissionService{

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermissionVo> findListPage(SysPermissionVo vo) {
        return null;
    }

    @Override
    public int count(SysPermissionVo vo) {
        return 0;
    }

    @Override
    public SysPermission save(SysPermissionVo vo) throws IllegalAccessException, InstantiationException {
        return null;
    }

    @Override
    public SysPermission update(SysPermissionVo vo) {
        return null;
    }

    @Override
    public BaseDao<SysPermission> getBaseDao() {
        return sysPermissionDao;
    }
}
