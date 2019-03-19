package com.lq.cms.web.sys;

import com.alibaba.fastjson.JSON;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.mode.ZtreeComposite;
import com.lq.cms.service.SysRoleResourcePermissionService;
import com.lq.cms.service.SysRoleService;
import com.lq.cms.vo.SysRoleResourcePermissionVo;
import com.lq.cms.vo.SysRoleVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.BeanUtil;
import com.lq.entity.SysRole;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/2/1.
 */
@Controller
@RequestMapping("/cms/role")
public class RoleController  {

    private static Logger LOGGER = Logger.getLogger(RoleController.class);


    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleResourcePermissionService sysRoleResourcePermissionService;


    @RequiresPermissions("/cms/role/index:SELECT")
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.setViewName("cms/sys/role/index");
        return modelAndView;
    }

    @RequiresPermissions("/cms/role/index:SELECT")
    @RequestMapping("/list")
    @ResponseBody
    public Object list(SysRoleVo vo){
        Map<String,Object> map=new HashMap();

        map.put("total",sysRoleService.count(vo));
        map.put("rows",sysRoleService.findListPage(vo));
        return map;
    }

    @RequiresPermissions(value={"/cms/role/index:INSERT","/cms/role/index:UPDATE"},logical = Logical.OR)
    @RequestMapping("/edit")
    public ModelAndView edit(ModelAndView modelAndView,Long id){
        if (id!=null) {
            SysRole sysRole = sysRoleService.findOne(id);
            modelAndView.addObject("sysRole",sysRole);
        }
        modelAndView.setViewName("cms/sys/role/edit");
        return modelAndView;
    }

    @RequiresPermissions("/cms/role/index:UPDATE")
    @RequestMapping("/permissionEdit")
    public ModelAndView permission(ModelAndView modelAndView,Long roleId){
        List<ZtreeComposite> list=sysRoleResourcePermissionService.findZtree(roleId);
        String jsonStr= JSON.toJSONString(list);
        modelAndView.addObject("permissionList",jsonStr);
        modelAndView.setViewName("cms/sys/role/permissionEdit");
        return modelAndView;
    }

    @RequiresPermissions("/cms/role/index:UPDATE")
    @RequestMapping("/updatePermission")
    @ResponseBody
    public Object updatePermission(@RequestBody List<SysRoleResourcePermissionVo> list){
        AjaxResult ajaxResult=new AjaxResult();
        boolean result=sysRoleResourcePermissionService.updateRolePermission(list);
        return ajaxResult;
    }

    @RequiresPermissions("/cms/role/index:UPDATE")
    @RequestMapping("/save")
    @ResponseBody
    public Object save(SysRole sysRole){
        Date nowTime = new Date();
        AjaxResult ajaxResult = new AjaxResult(true," 保存成功","");
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

    @RequiresPermissions("/cms/role/index:UPDATE")
    @RequestMapping("/update")
    @ResponseBody
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

    @RequiresPermissions("/cms/role/index:DELETE")
    @RequestMapping("/delete")
    @ResponseBody
    public Object delte(SysRole sysRole){
        AjaxResult ajaxResult=new AjaxResult();
        if (sysRole!=null&&sysRole.getId()!=null){
            sysRoleService.delete(sysRole.getId());
        }
        return ajaxResult;
    }


}
