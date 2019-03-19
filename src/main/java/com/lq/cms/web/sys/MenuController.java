package com.lq.cms.web.sys;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.SysResourceService;
import com.lq.cms.vo.SysResourceVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.web.BaseController;
import com.lq.entity.SysResource;
import com.lq.entity.SysUser;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** 菜单控制类
 * Created by qi_liang on 2018/1/25.
 */
@Controller
@RequestMapping("/cms/menu")
public class MenuController {

    private static Logger LOGGER = Logger.getLogger(MenuController.class);

    @Autowired
    private SysResourceService sysResourceService;

    @RequiresPermissions("/cms/menu/index:SELECT")
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.setViewName("cms/sys/menu/index");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions("/cms/menu/index:SELECT")
    public Object list(SysResourceVo vo){
        Map<String,Object> map=new HashMap();
        map.put("total",sysResourceService.count(vo));
        map.put("rows",sysResourceService.findListpages(vo));
        return map;
    }

    @RequestMapping("/edit")
    @RequiresPermissions(value={"/cms/menu/index:INSERT","/cms/menu/index:UPDATE"},logical = Logical.OR)
    public ModelAndView edit(ModelAndView modelAndView,Long id){
        //查询可选择的上级目录
        List<SysResource> list=sysResourceService.findByParentId(0L);
        SysResource sysResource=sysResourceService.findOne(id);
        modelAndView.addObject("menuList",list);
        modelAndView.addObject("sysResource",sysResource);
        modelAndView.setViewName("cms/sys/menu/edit");
        return modelAndView;
    }

    @RequiresPermissions("/cms/menu/index:INSERT")
    @ResponseBody
    @RequestMapping("save")
    public Object save(SysResourceVo vo){
        Date nowTime = new Date();
        AjaxResult ajaxResult = new AjaxResult();
        Subject subject= SecurityUtils.getSubject();
        SysUser sysUser=(SysUser) subject.getPrincipal();

        if (vo!=null){
            SysResource sysResource = new SysResource();
            BeanUtils.copyProperties(vo,sysResource);
            sysResource.setCreateTime(nowTime);
            sysResource.setUpdateTime(nowTime);
            sysResource.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            if (sysUser!=null){
                sysResource.setUserId(sysUser.getId());
            }
            sysResourceService.save(sysResource);
        }else {
            ajaxResult.setMsg("数据提交失败");
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequiresPermissions("/cms/menu/index:UPDATE")
    @ResponseBody
    @RequestMapping("update")
    public Object update(SysResourceVo vo){
        AjaxResult ajaxResult = new AjaxResult();
        if (vo!=null&&vo.getId()!=null){
            SysResource sysResource = sysResourceService.findOne(vo.getId());
            BeanUtils.copyProperties(vo,sysResource);
            sysResource.setUpdateTime(new Date());
            sysResourceService.update(sysResource);
        }else {
            ajaxResult.setMsg("数据提交失败");
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequiresPermissions("/cms/menu/index:DELETE")
    @RequestMapping("/delete")
    @ResponseBody
    public Object delte(SysResource sysResource){
        AjaxResult ajaxResult=new AjaxResult();
        if (sysResource!=null&&sysResource.getId()!=null){
            sysResourceService.delete(sysResource.getId());
        }

        return ajaxResult;
    }



}
