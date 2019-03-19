package com.lq.dao;

import com.lq.code.dao.BaseDao;
import com.lq.cms.vo.PermissionVo;
import com.lq.entity.SysRoleResourcePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysRoleResourcePermissionDao extends BaseDao<SysRoleResourcePermission> {

    List<PermissionVo> findByRoleId(@Param("roleId") Long roleId);

    SysRoleResourcePermission findByResourceIdAndPermissionIdAndRoleId(@Param("resourceId") Long resourceId, @Param("permissonId") Long permissonId, @Param("roleId") Long roleId);

    void updateByRoleIdAndStatus(Map<String, Object> param);

    List<PermissionVo> findAllPermission();

    void deleteByRoleId(Long roleId);
}
