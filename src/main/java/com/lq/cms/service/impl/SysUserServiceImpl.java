package com.lq.cms.service.impl;

import com.lq.cms.service.SysUserService;
import com.lq.cms.vo.SysUserVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.util.Md5Util;
import com.lq.dao.SysUserDao;
import com.lq.dao.SysUserRoleDao;
import com.lq.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户相关事务类
 * @author qi
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;



    @Override
    public BaseDao<SysUser> getBaseDao() {
        return sysUserDao;
    }


    @Override
    public List<SysUserVo> findListPage(SysUserVo vo) {
        return sysUserDao.findListPage(vo);
    }

    @Override
    public Integer count(SysUserVo vo) {
        return sysUserDao.count(vo);
    }

    @Override
    public SysUser findByLoginNameAndPassword(String loginName, String pass) {
        String md5Pass= Md5Util.getMd5(pass);
        SysUser sysUser=sysUserDao.findByLoginNameAndPassword(loginName,md5Pass);
        return sysUser;
    }

    @Override
    public SysUser findByEmail(String email) {
        return sysUserDao.findByEmail(email);
    }

    @Override
    @Transactional
    public void deleteUserById(Long userId) {
        //删除用户关联的角色
        sysUserRoleDao.deleteByUserId(userId);
        //删除用户
        sysUserDao.delete(userId);
    }
}
