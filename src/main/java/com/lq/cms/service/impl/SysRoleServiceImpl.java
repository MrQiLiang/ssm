package com.lq.cms.service.impl;

import com.lq.cms.service.SysRoleService;
import com.lq.cms.vo.SysRoleVo;
import com.lq.cms.vo.SysUserRoleVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.dao.SysRoleDao;
import com.lq.dao.SysUserRoleDao;
import com.lq.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public BaseDao<SysRole> getBaseDao() {
        return sysRoleDao;
    }

    @Override
    public Integer count(SysRoleVo vo) {
        return sysRoleDao.count(vo);
    }

    @Override
    public List<SysRoleVo> findListPage(SysRoleVo vo) {
        return sysRoleDao.findListPage(vo);
    }

    @Override
    public List<SysUserRoleVo> findAllRoleVo(Long id) {
        return sysUserRoleDao.findAllRoleVo(id);
    }

    @Override
    public List<SysRole> findByUserId(Long userId) {

        List<SysRole> sysRoleList=sysRoleDao.findByUserId(userId);
        return sysRoleList;
    }
}
