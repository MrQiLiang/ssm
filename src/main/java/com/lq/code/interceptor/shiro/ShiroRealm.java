package com.lq.code.interceptor.shiro;

import com.lq.cms.service.SysRoleResourcePermissionService;
import com.lq.cms.service.SysRoleService;
import com.lq.cms.service.SysUserService;
import com.lq.cms.vo.PermissionVo;
import com.lq.code.util.Constant;
import com.lq.code.util.StringUtil;
import com.lq.entity.SysRole;
import com.lq.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 授权权
 * @author qi
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleResourcePermissionService sysRoleResourcePermissionService;


    /**
     *  用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser=(SysUser)principalCollection.getPrimaryPrincipal();
        //用户拥有的角色
        List<SysRole> sysRoleList=sysRoleService.findByUserId(sysUser.getId());
        SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
        if (sysRoleList != null) {
            Iterator<SysRole> sysRoleIterator = sysRoleList.iterator();
            while (sysRoleIterator.hasNext()){
                SysRole sysRole = sysRoleIterator.next();
                String sysRoleName = sysRole.getRoleName();
                info.addRole(sysRoleName);
                List<PermissionVo> permissionVos = null;
                //admin默认获取全部权限
                if (StringUtil.isNotNull(sysRoleName)&& Constant.ROLE_ADMIN.equals(sysRoleName)){
                    permissionVos = sysRoleResourcePermissionService.findAllPermissonVo();
                }else {
                    permissionVos = sysRoleResourcePermissionService.findByRoleId(sysRole.getId());
                }
                //每个角色拥有的权限
                for (PermissionVo vo:permissionVos){
                    info.addStringPermission(vo.getMenuUrl()+Constant.PERSSION_MARK+vo.getPermissionName());
                }
                if (Constant.ROLE_ADMIN.equals(sysRoleName)){
                    break;
                }

            }
        }

        return info;
    }

    /**
     *  登陆验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String password = new String(token.getPassword());
        SysUser sysUser=sysUserService.findByLoginNameAndPassword(token.getUsername(),password);
        if (sysUser==null){
            return null;
        }
        sysUser.setLastLoginTime(new Date());
        sysUserService.update(sysUser);
        String realmName=this.getName();
        return new SimpleAuthenticationInfo(sysUser,password,realmName);
    }
}
