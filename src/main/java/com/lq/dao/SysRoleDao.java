package com.lq.dao;

import com.lq.cms.vo.SysRoleVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysRoleDao extends BaseDao<SysRole> {

    List<SysRole> findByUserId(@Param("userId") Long userId);

    List<SysRole> findAll();

    Integer count(SysRoleVo vo);

    List<SysRoleVo> findListPage(SysRoleVo vo);
}
