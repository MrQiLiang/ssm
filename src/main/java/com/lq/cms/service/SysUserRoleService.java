package com.lq.cms.service;

import com.lq.code.dao.BaseDao;
import com.lq.code.service.BaseService;
import com.lq.entity.SysUserRole;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {
    void updateUserRole(Long id, List<Long> roleList);
}
