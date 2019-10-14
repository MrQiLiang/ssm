package com.lq;


import com.github.jsonzou.jmockdata.JMockData;
import com.lq.cms.emun.BasicsPermissionKeyEnum;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.dao.SysLogDao;
import com.lq.dao.SysPermissionDao;
import com.lq.dao.SysResourceDao;
import com.lq.dao.SysUserDao;
import com.lq.entity.SysLog;
import com.lq.entity.SysPermission;
import com.lq.entity.SysResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SysPermissionServiceTest extends BaseTest {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private SysLogDao sysLogDao;

    @Test
    public void test1(){
        int length = 1;

        while (length>0){
            SysLog sysLog = JMockData.mock(SysLog.class);
            sysLog.setId(null);
            sysLog.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            sysLogDao.save(sysLog);
            length--;
        }

    }

    public void test(){

        //1.查询所有菜单
        List<SysResource> sysResourceList = sysResourceDao.findAll();

        //2.构建基本的权限
     //   List<SysPermission> sysPermissionList = new ArrayList<>();
        BasicsPermissionKeyEnum[] basicsPermissionKeyEnums = BasicsPermissionKeyEnum.values();
        sysResourceList.forEach((sysResource)->{
            for (BasicsPermissionKeyEnum basicsPermissionKeyEnum:basicsPermissionKeyEnums){
                SysPermission sysPermission = new SysPermission();
                sysPermission.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                sysPermission.setSysResourceId(sysResource.getId());
                sysPermission.setName(basicsPermissionKeyEnum.getDesc());
                sysPermission.setPermissionKey(basicsPermissionKeyEnum.getValue());
                sysPermission.setPermissionType(basicsPermissionKeyEnum.getType());
                sysPermission.setCreateTime(new Date());
                sysPermission.setCreateUserId(1L);
                sysPermission.setUpdateTime(new Date());
                sysPermission.setUpdateUserId(1L);
              //  sysPermissionList.add(sysPermission);
     //           sysPermissionDao.save(sysPermission);
            }
        });
        //3.权限入库
     //   sysPermissionDao.batchSave(sysPermissionList);
    }
}
