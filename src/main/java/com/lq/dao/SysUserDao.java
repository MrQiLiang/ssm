package com.lq.dao;

import com.lq.cms.vo.SysUserVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户dao
 * @author qi
 */
public interface SysUserDao extends BaseDao<SysUser> {

    /**
     * 通过登陆名和密码查找账号
     * @param loginName
     * @param password
     * @return
     */
    SysUser findByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    /**
     * 分页查询
     * @param vo
     * @return
     */
    List<SysUserVo> findListPage(SysUserVo vo);

    Integer count(SysUserVo vo);

    SysUser findByEmail(@Param("email") String email);
}
