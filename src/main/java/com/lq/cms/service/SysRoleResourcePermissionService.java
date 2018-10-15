package com.lq.cms.service;

import com.lq.cms.mode.ZtreeComposite;
import com.lq.cms.vo.PermissionVo;
import com.lq.cms.vo.SysRoleResourcePermissionVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysRoleResourcePermission;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface SysRoleResourcePermissionService extends BaseService<SysRoleResourcePermission> {

    /**
     *  通过角色查找菜单
     * @param roleId
     * @return
     */
    List<ZtreeComposite> findZtree(Long roleId);

    /**
     * 更新角色权限列表
     * @param list
     * @return
     */
    boolean updateRolePermission(List<SysRoleResourcePermissionVo> list);

    /**
     *  通过角色查找权限
     * @param roleId
     * @return
     */
    List<PermissionVo> findByRoleId(Long roleId);

    /**
     *  查找全部权限，默认是admin角色
     * @return
     */
    List<PermissionVo> findAllPermissonVo();
}
