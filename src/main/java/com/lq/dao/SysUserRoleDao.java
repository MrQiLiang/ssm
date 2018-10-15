package com.lq.dao;

import com.lq.cms.vo.SysUserRoleVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysUserRoleDao extends BaseDao<SysUserRole> {

    Long save(SysUserRole sysUserRole);

    List<SysUserRole> findByUserIdAndRoleId(Map<String, Object> params);

    List<SysUserRoleVo> findAllRoleVo(Long userId);

    void deleteByUserId(Long userId);

}
