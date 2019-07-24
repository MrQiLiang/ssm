package com.lq.cms.web.sys;

import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.SysPermissionService;
import com.lq.cms.vo.SysPermissionVo;
import com.lq.code.entity.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: qi
 * @Description:权限控制类
 * @Date: Create in 11:21 PM 2019/7/22
 */
@Controller
@RequestMapping("/cms/permission")
public class PermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("/index")
    public String index(){

        return "cms/sys/permission/index";
    }

    @RequestMapping("/edit")
    public String edit(){

        return "cms/sys/permission/edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Object list(SysPermissionVo vo){
        AdminDataGridParam<SysPermissionVo> adminDataGridParam = new AdminDataGridParam<>();
        adminDataGridParam.setRows(sysPermissionService.findListPage(vo));
        adminDataGridParam.setTotal(sysPermissionService.count(vo));
        return adminDataGridParam;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(SysPermissionVo vo){

        return new AjaxResult();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(SysPermissionVo vo){

        return new AjaxResult();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(SysPermissionVo vo){

        return new AjaxResult();
    }

}
