package com.lq.cms.service.impl;

import com.lq.cms.emun.BasicsPermissionKeyEnum;
import com.lq.cms.emun.PermissionTyepEnum;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.mode.Ztree;
import com.lq.cms.mode.ZtreeComposite;
import com.lq.cms.mode.ZtreeItem;
import com.lq.cms.service.SysRoleResourcePermissionService;
import com.lq.cms.vo.PermissionVo;
import com.lq.cms.vo.SysRoleResourcePermissionVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.dao.SysPermissionDao;
import com.lq.dao.SysResourceDao;
import com.lq.dao.SysRoleResourcePermissionDao;
import com.lq.entity.SysPermission;
import com.lq.entity.SysResource;
import com.lq.entity.SysRoleResourcePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by qi_liang on 2018/6/21.
 */
@Service
public class SysRoleResourcePermissionServiceImpl extends BaseServiceImpl<SysRoleResourcePermission> implements SysRoleResourcePermissionService {

    public static final String RESOURCE_SYMBOL = "_";

    public static final String PERMISSIONID_KEY = "id_permissionId";

    @Autowired
    private SysRoleResourcePermissionDao sysRoleResourcePermissionDao;

    @Autowired
    private SysResourceDao sysResourceDao;

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public BaseDao<SysRoleResourcePermission> getBaseDao() {
        return sysRoleResourcePermissionDao;
    }

    @Override
    public List<ZtreeComposite> findZtree(Long roleId) {
        List<ZtreeComposite> ztreeList=new ArrayList<>();
        List<SysResource> resourceList=sysResourceDao.findByParentId(0L);

        for (SysResource sysResource:resourceList){
            ZtreeItem ztreeItem=new ZtreeItem();
            ztreeItem.setId(sysResource.getId());
            ztreeItem.setIconCls(sysResource.getMenuIco());
            ztreeItem.setText(sysResource.getMenuName());
            ztreeItem.setChecked(isCheck(sysResource.getId(), PermissionTyepEnum.SELECT.getValue(),roleId));
            ztreeItem.setState("close");
            ztreeItem.setAttributes(getAttributes(sysResource.getId(), Long.valueOf(PermissionTyepEnum.SELECT.getValue())));
            List<SysResource> menuItmeList=sysResourceDao.findByParentId(sysResource.getId());
            for (SysResource resource:menuItmeList){
                ZtreeItem ztreeItme1=new ZtreeItem();
                ztreeItme1.setId(resource.getId());
                ztreeItme1.setText(resource.getMenuName());
                ztreeItme1.setIconCls(resource.getMenuIco());
                ztreeItme1.setChecked(isCheck(resource.getId(), PermissionTyepEnum.SELECT.getValue(),roleId));
                ztreeItme1.setAttributes(getAttributes(resource.getId(),PermissionTyepEnum.SELECT.getValue()));
                List<SysPermission> permissionList = sysPermissionDao.findBySysResourceId(resource.getId());
                for (SysPermission sysPermission:permissionList){
                    if (BasicsPermissionKeyEnum.SELECT_MENU_KEY.getValue().equals(sysPermission.getPermissionKey())){
                        continue;
                    }
                    Ztree ztree=new Ztree();
                    ztree.setId(sysPermission.getId());
                    ztree.setChecked(isCheck(resource.getId(),sysPermission.getId(),roleId));
                    ztree.setText(sysPermission.getName());
                    ztree.setAttributes(getAttributes(resource.getId(),sysPermission.getId()));
                    ztreeItme1.add(ztree);
                }
                ztreeItem.add(ztreeItme1);
            }

            ztreeList.add(ztreeItem);
        }
        return ztreeList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateRolePermission(List<SysRoleResourcePermissionVo> list) {
        //角色id
        Long roleId=list.get(0).getRoleId();
        Map<String,Object> map=new HashMap<>(2);
        map.put("roleId",roleId);
        map.put("state", StatusTypeEnum.STATUS_ACTIVITY_NO.getValue());
        sysRoleResourcePermissionDao.updateByRoleIdAndStatus(map);

        for (SysRoleResourcePermissionVo vo:list){
            SysRoleResourcePermission sysRoleResourcePermission=sysRoleResourcePermissionDao.getByResourceIdAndPermissionIdAndRoleId(vo.getResourceId(),vo.getPermissionId(),vo.getRoleId());
            if (sysRoleResourcePermission==null){
                sysRoleResourcePermission=new SysRoleResourcePermission();
                sysRoleResourcePermission.setCreateTime(new Date());
                sysRoleResourcePermission.setResourceId(vo.getResourceId());
                sysRoleResourcePermission.setRoleId(vo.getRoleId());
                sysRoleResourcePermission.setPermissionId(vo.getPermissionId());
                sysRoleResourcePermission.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                sysRoleResourcePermissionDao.save(sysRoleResourcePermission);
            }else {
                sysRoleResourcePermission.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                sysRoleResourcePermissionDao.update(sysRoleResourcePermission);
            }

        }

        return true;
    }

    @Override
    public List<PermissionVo> findByRoleId(Long roleId) {
        List<PermissionVo> list=sysRoleResourcePermissionDao.findByRoleId(roleId);
        return list;
    }

    @Override
    public List<PermissionVo> findAllPermissonVo() {
        List<PermissionVo> list = new ArrayList<>();
        List<SysResource> sysResourceList =  sysResourceDao.findAll();
        Iterator iterator = sysResourceList.iterator();
        PermissionTyepEnum[] tyepEnums = PermissionTyepEnum.values();
        while (iterator.hasNext()){
            SysResource sysResource = (SysResource) iterator.next();
            if (sysResource!=null){
                for (PermissionTyepEnum permissionTyepEnum:tyepEnums){
                    PermissionVo permissionVo = new PermissionVo();
                    permissionVo.setMenuId(sysResource.getId());
                    permissionVo.setMenuName(sysResource.getMenuName());
                    permissionVo.setMenuUrl(sysResource.getUrlPath());
                    permissionVo.setPermissionName(permissionTyepEnum.getConstant());
                    list.add(permissionVo);
                }
            }

        }
        return list;
    }

    /**
     *内部方法，用于判断角色是否有权限
     */
    private boolean isCheck(Long resourceId,Long permissionId,Long roleId){
        SysRoleResourcePermission roleResourcePermission=sysRoleResourcePermissionDao.getByResourceIdAndPermissionIdAndRoleId(resourceId,permissionId,roleId);
        if (roleResourcePermission!=null&&StatusTypeEnum.STATUS_ACTIVITY_YES.getValue().equals(roleResourcePermission.getStatus())){
            return true;
        }else{
            return false;
        }
    }

    /**
     *内部方法，拼接资源和权限ID
     */
    private Map<String,Object> getAttributes(Long resourceId,Long permissionId){
        Map<String,Object> map=new HashMap<>();
        map.put(PERMISSIONID_KEY,resourceId+RESOURCE_SYMBOL+permissionId);
        return map;
    }
}
