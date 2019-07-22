package com.lq.dao;

import com.lq.cms.vo.SysPermissionVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysPermission;

import java.util.List;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysPermissionDao extends BaseDao<SysPermission>{

    List<SysPermissionVo> findListPage(SysPermissionVo vo);

    int count(SysPermissionVo vo);

}
