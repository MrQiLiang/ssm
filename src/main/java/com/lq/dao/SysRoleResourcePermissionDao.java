package com.lq.dao;

import com.lq.cms.vo.PermissionVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysRoleResourcePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色资源权限dao
 * @author qi
 */
public interface SysRoleResourcePermissionDao extends BaseDao<SysRoleResourcePermission> {

    List<PermissionVo> findByRoleId(@Param("roleId") Long roleId);

    /**
     *  通过资源ID，权限ID和角色ID查找3者关联表
     * @param resourceId(角色ID)
     * @param permissonId
     * @param roleId
     * @return
     */
    SysRoleResourcePermission getByResourceIdAndPermissionIdAndRoleId(@Param("resourceId") Long resourceId, @Param("permissonId") Long permissonId, @Param("roleId") Long roleId);

    void updateByRoleIdAndStatus(Map<String, Object> param);

    List<PermissionVo> findAllPermission();

    void deleteByRoleId(Long roleId);
}
