package com.lq.cms.service.impl;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.SysUserRoleService;
import com.lq.code.dao.BaseDao;
import com.lq.dao.SysUserRoleDao;
import com.lq.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/21.
 * @author qi
 */
@Service
public class SysUserRoleServiceImpl  implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public BaseDao<SysUserRole> getBaseDao() {
        return sysUserRoleDao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUserRole(Long id, List<Long> roleList) {
        Date nowTime=new Date();
        sysUserRoleDao.deleteByUserId(id);
        if (roleList!=null&&roleList.size()>0) {
            roleList.forEach(roleId->{
                SysUserRole sysUserRole = findByRoleIdAndUserId(id, roleId);
                if (sysUserRole != null) {
                    sysUserRole.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                    sysUserRole.setUpdateTime(nowTime);
                    sysUserRoleDao.update(sysUserRole);
                } else {
                    sysUserRole = new SysUserRole();
                    sysUserRole.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                    sysUserRole.setCreateTime(nowTime);
                    sysUserRole.setUpdateTime(nowTime);
                    sysUserRole.setUserId(id);
                    sysUserRole.setRoleId(roleId);
                    sysUserRoleDao.save(sysUserRole);
                }
            });
        }
    }

    public SysUserRole findByRoleIdAndUserId(Long userId,Long roleId){
        Map<String,Object> map=new HashMap(2);
        map.put("userId",userId);
        map.put("roleId",roleId);
        List<SysUserRole> list=sysUserRoleDao.findByUserIdAndRoleId(map);
        return list.size()==0?null:list.get(0);
    }
}
