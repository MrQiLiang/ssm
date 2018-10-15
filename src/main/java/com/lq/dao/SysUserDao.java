package com.lq.dao;

import com.lq.cms.vo.SysUserVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysUserDao extends BaseDao<SysUser> {

    SysUser findByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    List<SysUserVo> findListPage(SysUserVo vo);

    Integer count(SysUserVo vo);

    SysUser findByEmail(@Param("email") String email);
}
