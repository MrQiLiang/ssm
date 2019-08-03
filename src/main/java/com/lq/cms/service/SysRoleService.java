package com.lq.cms.service;

import com.lq.cms.vo.SysRoleVo;
import com.lq.cms.vo.SysUserRoleVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysRole;

import java.util.List;

/**
 * @author qi
 * 角色事务类
 */
public interface SysRoleService extends BaseService<SysRole> {

    Integer count(SysRoleVo vo);

    List<SysRoleVo> findListPage(SysRoleVo vo);

    List<SysUserRoleVo> findAllRoleVo(Long userId);

    List<SysRole> findByUserId(Long userId);

    void deleteRole(Long roleId);
}
