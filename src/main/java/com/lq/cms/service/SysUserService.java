package com.lq.cms.service;

import com.lq.cms.vo.SysUserVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysUser;

import java.util.List;

/**
 * @author qi
 */
public interface SysUserService extends BaseService<SysUser> {

    List<SysUserVo> findListPage(SysUserVo vo);

    Integer count(SysUserVo vo);

    SysUser findByLoginNameAndPassword(String loginName, String password);

    SysUser findByEmail(String email);

    void deleteUserById(Long userId);
}
