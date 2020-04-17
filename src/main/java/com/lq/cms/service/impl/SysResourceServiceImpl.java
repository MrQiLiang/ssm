package com.lq.cms.service.impl;

import com.lq.cms.emun.PermissionTypeEnum;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.mode.Menus;
import com.lq.cms.mode.MenusComposite;
import com.lq.cms.mode.MenusItem;
import com.lq.cms.service.SysResourceService;
import com.lq.cms.vo.SysResourceVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.util.Constant;
import com.lq.dao.SysResourceDao;
import com.lq.entity.SysResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by qi_liang on 2018/6/21.
 * @author qi
 */
@Service
public class SysResourceServiceImpl  implements SysResourceService {

    @Autowired
    private SysResourceDao sysResourceDao;

    @Override
    public BaseDao<SysResource> getBaseDao() {
        return sysResourceDao;
    }

    @Override
    public Integer count(SysResourceVo vo) {
        vo.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        return sysResourceDao.count(vo);
    }

    @Override
    public List<SysResourceVo> findListPages(SysResourceVo vo) {

        vo.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        return sysResourceDao.findListPage(vo);
    }

    @Override
    public List<SysResource> findByParentId(long parenId) {
        return sysResourceDao.findByParentId(parenId);
    }

    @Override
    public List<MenusComposite> findMenusListBySysUserId(Long sysUserId, String contextPath) {
         Map<String,Object> map=new HashMap(3);
        map.put("userId",sysUserId);
        map.put("parentId", Constant.TOP_PARENT_ID);
        map.put("permissionId", PermissionTypeEnum.SELECT.getValue());
        List<SysResource> menusItmeList=sysResourceDao.findMenu(map);
        List<MenusComposite> list=new ArrayList<>();
        menusItmeList.forEach(sysResource->{
            MenusItem menusItem=new MenusItem();
            menusItem.setMenuname(sysResource.getMenuName());
            menusItem.setIcon(sysResource.getMenuIco());
            menusItem.setMenuid(sysResource.getId());
            map.put("parentId",sysResource.getId());
            List<SysResource> menusList=sysResourceDao.findMenu(map);;
            for (SysResource sysResource1: menusList){
                Menus menus=new Menus();
                menus.setMenuid(sysResource1.getId());
                menus.setIcon(sysResource1.getMenuIco());
                menus.setMenuname(sysResource1.getMenuName());
                menus.setUrl(contextPath+sysResource1.getUrlPath());
                menusItem.add(menus);
            }
            list.add(menusItem);

        });

        return list;
    }

    @Override
    public List<MenusComposite> findAllMenusList(String contextPath) {
        List<SysResource> sysResourceList = sysResourceDao.findByParentId(0L);
        Iterator<SysResource> sysResourceIterator = sysResourceList.iterator();
        List<MenusComposite> list=new ArrayList<>();
        while (sysResourceIterator.hasNext()){
            SysResource sysResource = sysResourceIterator.next();
            MenusItem menusItem=new MenusItem();
            menusItem.setMenuname(sysResource.getMenuName());
            menusItem.setIcon(sysResource.getMenuIco());
            menusItem.setMenuid(sysResource.getId());
            List<SysResource> nextSysReousrceList= sysResourceDao.findByParentId(sysResource.getId());
            Iterator<SysResource> nextSysResousrceIterator = nextSysReousrceList.iterator();
            while (nextSysResousrceIterator.hasNext()){
                SysResource nextSysResource = nextSysResousrceIterator.next();
                Menus menus=new Menus();
                menus.setMenuid(nextSysResource.getId());
                menus.setIcon(nextSysResource.getMenuIco());
                menus.setMenuname(nextSysResource.getMenuName());
                menus.setUrl(contextPath+nextSysResource.getUrlPath());
                menusItem.add(menus);
            }
            list.add(menusItem);
        }

        return list;
    }
}
