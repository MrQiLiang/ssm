package com.lq.cms.service;

import com.lq.cms.vo.SysUserVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysUser;
import org.apache.bcel.verifier.statics.LONG_Upper;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface SysUserService extends BaseService<SysUser> {

    List<SysUserVo> findListPage(SysUserVo vo);

    Integer count(SysUserVo vo);

    SysUser findByLoginNameAndPassword(String loginName, String password);

    SysUser findByEmail(String email);

    void deleteUserById(Long userId);
}
