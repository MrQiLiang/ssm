package com.lq.cms.service.impl;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.SysPermissionService;
import com.lq.cms.vo.SysPermissionVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.code.util.BeanUtil;
import com.lq.dao.SysPermissionDao;
import com.lq.dao.SysResourceDao;
import com.lq.dao.SysUserDao;
import com.lq.entity.SysPermission;
import com.lq.entity.SysResource;
import com.lq.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysPermissionVo> findListPage(SysPermissionVo vo) {
        List<SysPermissionVo> sysPermissionVos = sysPermissionDao.findListPage(vo);
        sysPermissionVos.forEach(sysPermissionVo1->{
            if (sysPermissionVo1.getSysResourceId()!=null) {
                SysResource sysResource = sysResourceDao.findOne(sysPermissionVo1.getSysResourceId());
                if (sysResource!=null) {
                    sysPermissionVo1.setSysResourceName(sysResource.getMenuName());
                }
            }
            if (sysPermissionVo1.getCreateUserId()!=null) {
                SysUser createUser = sysUserDao.findOne(sysPermissionVo1.getCreateUserId());
                if (createUser!=null) {
                    sysPermissionVo1.setCreateUserName(createUser.getLoginName());
                }
            }
            if (sysPermissionVo1.getUpdateUserId()!=null) {
                SysUser updateUser = sysUserDao.findOne(sysPermissionVo1.getUpdateUserId());
                if (updateUser!=null) {
                    sysPermissionVo1.setUpdateUserName(updateUser.getLoginName());
                }
            }

        });
        return sysPermissionVos;
    }

    @Override
    public int count(SysPermissionVo vo) {
        return sysPermissionDao.count(vo);
    }

    @Override
    public SysPermission save(SysPermissionVo vo){
        Subject subject= SecurityUtils.getSubject();
        SysUser sysUser=(SysUser) subject.getPrincipal();
        SysPermission sysPermission = new SysPermission();
        BeanUtil.copyNotNull(sysPermission,vo);
        sysPermission.setCreateTime(new Date());
        sysPermission.setCreateUserId(sysUser.getId());
        sysPermission.setUpdateTime(new Date());
        sysPermission.setUpdateUserId(sysUser.getId());
        sysPermission.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        sysPermissionDao.save(sysPermission);
        return sysPermission;
    }

    @Override
    public SysPermission update(SysPermissionVo vo) {
        Subject subject= SecurityUtils.getSubject();
        SysUser sysUser=(SysUser) subject.getPrincipal();
        SysPermission sysPermission = sysPermissionDao.findOne(vo.getId());
        BeanUtil.copyNotNull(sysPermission,vo);
        sysPermission.setUpdateUserId(sysUser.getId());
        sysPermission.setUpdateTime(new Date());
        sysPermissionDao.update(sysPermission);
        return sysPermission;
    }

    @Override
    public BaseDao<SysPermission> getBaseDao() {
        return sysPermissionDao;
    }
}
