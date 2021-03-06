package com.lq.cms.web.sys;

import com.alibaba.fastjson.JSON;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.mode.ZtreeComposite;
import com.lq.cms.service.SysRoleResourcePermissionService;
import com.lq.cms.service.SysRoleService;
import com.lq.cms.service.SysUserRoleService;
import com.lq.cms.vo.SysRoleResourcePermissionVo;
import com.lq.cms.vo.SysRoleVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.Constant;
import com.lq.entity.SysRole;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author qi
 * 角色相关
 */
@Controller
@RequestMapping("/cms/role")
public class RoleController  {

    public static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    public static final String INDEX_URL = "/cms/role/index";

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleResourcePermissionService sysRoleResourcePermissionService;
    @Autowired
    private SysUserRoleService sysUserRoleService;


    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.setViewName("cms/sys/role/index");
        return modelAndView;
    }



    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_SELECT)
    public Object list(SysRoleVo vo){
        AdminDataGridParam<SysRoleVo> adminDataGridParam = new AdminDataGridParam<>();
        adminDataGridParam.setTotal(sysRoleService.count(vo));
        adminDataGridParam.setRows(sysRoleService.findListPage(vo));
        return adminDataGridParam;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(ModelAndView modelAndView,Long id){
        if (id!=null) {
            SysRole sysRole = sysRoleService.findOne(id);
            modelAndView.addObject("sysRole",sysRole);
        }
        modelAndView.setViewName("cms/sys/role/edit");
        return modelAndView;
    }

    @RequestMapping("/permissionEdit")
    public ModelAndView permission(ModelAndView modelAndView,Long roleId){
        List<ZtreeComposite> list=sysRoleResourcePermissionService.findZtree(roleId);
        String jsonStr= JSON.toJSONString(list);
        modelAndView.addObject("permissionList",jsonStr);
        modelAndView.setViewName("cms/sys/role/permissionEdit");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/updatePermission")
    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_UPDATE)
    public Object updatePermission(@RequestBody List<SysRoleResourcePermissionVo> list){
        AjaxResult ajaxResult=AjaxResult.getSuccessInstance();
        boolean result=sysRoleResourcePermissionService.updateRolePermission(list);
        ajaxResult.setSuccess(result);
        if (!result){
            ajaxResult.setMsg("更新失败!");
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_INSERT)
    public Object save(SysRole sysRole){
        Date nowTime = new Date();
        AjaxResult ajaxResult =AjaxResult.getSuccessInstance();
        if (sysRole!=null){
            sysRole.setCreateTime(nowTime);
            sysRole.setUpdateTime(nowTime);
            sysRole.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            sysRoleService.save(sysRole);
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("保存失败");
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_UPDATE)
    public Object update(SysRole sysRole){
        AjaxResult ajaxResult = new AjaxResult(true," 保存成功","");
        if (sysRole!=null&&sysRole.getId()!=null){
            SysRole targerSysRole= sysRoleService.findOne(sysRole.getId());
            BeanUtil.copyNotNull(targerSysRole,sysRole);
            targerSysRole.setUpdateTime(new Date());
            sysRoleService.update(targerSysRole);
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("保存失败");
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_DELETE)
    public Object delte(SysRole sysRole){
        AjaxResult ajaxResult=new AjaxResult();
        if (sysRole!=null&&sysRole.getId()!=null){
            sysRoleService.deleteRole(sysRole.getId());
        }
        return ajaxResult;
    }


}
