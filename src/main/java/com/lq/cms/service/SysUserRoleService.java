package com.lq.cms.service;

import com.lq.code.service.BaseService;
import com.lq.entity.SysUserRole;

import java.util.List;

/**
 * @author qi
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {
    /**
     *  通过用户ID更新关联角色
     * @param id 用户ID
     * @param roleList 角色集合
     */
    void updateUserRole(Long id, List<Long> roleList);
}
