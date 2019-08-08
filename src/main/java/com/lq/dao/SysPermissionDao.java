package com.lq.dao;

import com.lq.cms.vo.SysPermissionVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysPermissionDao extends BaseDao<SysPermission>{
    /**
     *  分页查询
     * @param vo
     * @return
     */
    List<SysPermissionVo> findListPage(SysPermissionVo vo);

    /**
     * 统计数据条数
     * @param vo
     * @return
     */
    int count(SysPermissionVo vo);

    /**
     * 通过菜单ID查询相关权限
     * @param sysResourceId（菜单ID）
     * @return
     */
    List<SysPermission> findBySysResourceId(@Param("sysResourceId") Long sysResourceId);

}
