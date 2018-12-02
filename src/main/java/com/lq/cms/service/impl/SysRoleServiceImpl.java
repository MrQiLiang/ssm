package com.lq.cms.service.impl;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.SysRoleService;
import com.lq.cms.vo.SysRoleVo;
import com.lq.cms.vo.SysUserRoleVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.dao.SysRoleDao;
import com.lq.dao.SysRoleResourcePermissionDao;
import com.lq.dao.SysUserRoleDao;
import com.lq.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/21.
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private SysRoleResourcePermissionDao sysRoleResourcePermissionDao;

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


    @Override
    @Transactional
    public void deleteRole(Long roleId) {
        //删除角色关联的权限和菜单
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("roleId",roleId);
        paramsMap.put("status", StatusTypeEnum.STATUS_ACTIVITY_NO.getValue());
        sysRoleResourcePermissionDao.updateByRoleIdAndStatus(paramsMap);
        //删除用户角色表中关联
        sysUserRoleDao.deleteByUserId(roleId);
        //删除角色
        sysRoleDao.delete(roleId);
    }
}
