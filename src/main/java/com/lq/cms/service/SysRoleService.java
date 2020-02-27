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
    /**
     * 参数统计
     * @param vo
     * @return
     */
    Integer count(SysRoleVo vo);

    /**
     * 参数分页查询
     * @param vo
     * @return
     */
    List<SysRoleVo> findListPage(SysRoleVo vo);

    /**
     *
     * @param userId
     * @return
     */
    List<SysUserRoleVo> findAllRoleVo(Long userId);

    /**
     * 通过用户ID查询角色
     * @param userId
     * @return
     */
    List<SysRole> findByUserId(Long userId);

    /**
     * 通过角色ID删除角色
     * @param roleId
     */
    void deleteRole(Long roleId);
}
