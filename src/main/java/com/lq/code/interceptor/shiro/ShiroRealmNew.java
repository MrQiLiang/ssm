package com.lq.code.interceptor.shiro;

import com.lq.cms.service.SysRoleService;
import com.lq.cms.service.SysUserService;
import com.lq.entity.SysRole;
import com.lq.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 新版授权
 * @author qi
 */
public class ShiroRealmNew extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser=(SysUser)principalCollection.getPrimaryPrincipal();
        //用户拥有的角色
        List<SysRole> sysRoleList=sysRoleService.findByUserId(sysUser.getId());

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        SimpleAuthenticationInfo SimpleAuthenticationInfo = null;
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String pass = new String(token.getPassword());
        SysUser sysUser = sysUserService.findByLoginNameAndPassword(token.getUsername(),pass);
        if (sysUser!=null) {
            String realName = this.getName();
            sysUser.setLastLoginTime(new Date());
            sysUserService.update(sysUser);
            SimpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,pass,realName);
        }
        return SimpleAuthenticationInfo;
    }
}
