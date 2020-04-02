package com.lq.cms.web.sys;

import com.lq.cms.emun.SysPermissionTypeEnum;
import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.SysPermissionService;
import com.lq.cms.service.SysResourceService;
import com.lq.cms.vo.SysPermissionVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.web.BaseController;
import com.lq.entity.SysPermission;
import com.lq.entity.SysResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: qi
 * @Description:权限控制类
 * @Date: Create in 11:21 PM 2019/7/22
 */
@Controller
@RequestMapping("/cms/permission")
public class PermissionController extends BaseController{

    private static Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    private static final String INDEX_URL = "/cms/permission/index";

    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysResourceService sysResourceService;

    @RequestMapping("/index")
    public String index(){

        return "cms/sys/permission/index";
    }

    @RequestMapping("/edit")
    public String edit(Long id, Model model){
        if (id != null) {
            SysPermission sysPermission = sysPermissionService.findOne(id);
            model.addAttribute("sysPermission",sysPermission);
        }
        List<SysResource> sysResourceList=sysResourceService.findAll();
        model.addAttribute("menuList",sysResourceList);
        Map<String,String> permissionTypeMap = SysPermissionTypeEnum.getEnumMap();
        model.addAttribute("permissionTypeMap",permissionTypeMap);
        return "cms/sys/permission/edit";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Object list(SysPermissionVo vo){
        AdminDataGridParam<SysPermissionVo> adminDataGridParam = new AdminDataGridParam<>();
        adminDataGridParam.setRows(sysPermissionService.findListPage(vo));
        adminDataGridParam.setTotal(sysPermissionService.count(vo));
        return adminDataGridParam;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Object save(SysPermissionVo vo){
        AjaxResult ajaxResult = this.getAjaxResult();
        SysPermission sysPermission = sysPermissionService.save(vo);
        ajaxResult.setData(sysPermission);
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(SysPermissionVo vo){
        AjaxResult ajaxResult = this.getAjaxResult();   
        SysPermission sysPermission = sysPermissionService.update(vo);
        ajaxResult.setData(sysPermission);
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(SysPermissionVo vo){
        sysPermissionService.delete(vo.getId());

        return new AjaxResult();
    }

}
