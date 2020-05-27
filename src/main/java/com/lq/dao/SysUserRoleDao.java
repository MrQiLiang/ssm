package com.lq.dao;

import com.lq.cms.vo.SysUserRoleVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * 用户角色dao
 * @author qi
 */
public interface SysUserRoleDao extends BaseDao<SysUserRole> {

    /**
     * 通过用户id和角色id查找关联
     * @param params
     * @return
     */
    List<SysUserRole> findByUserIdAndRoleId(Map<String, Object> params);

    /**
     * 通过用户id查找用户关联角色
     * @param userId
     * @return
     */
    List<SysUserRoleVo> findAllRoleVo(Long userId);

    /**
     * 通过用户id删除关联
     * @param userId
     */
    void deleteByUserId(Long userId);

    void deleteByRoleId(Long roleId);

}
