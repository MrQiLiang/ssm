package com.lq.cms.web;

import com.lq.cms.emun.DatagridParamEnum;
import com.lq.cms.emun.PermissionTyepEnum;
import com.lq.cms.service.AdminBaseService;
import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.entity.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理后台 父类
 */
public abstract class AdminBaseController<T> {

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminBaseController.class);

    /**
     *  获取service
     * @return
     */
    public abstract AdminBaseService<T> getBaseService();

    /**
     *  管理后台url（用于权限控制）
     * @return
     */
    public abstract String getIndexUrl();

    public Map<String,Object> setPageDate(AdminBaseVo vo){
        Map<String,Object> map=new HashMap();
        map.put(DatagridParamEnum.TOTAL.getValue(),getBaseService().findListPage(vo));
        map.put(DatagridParamEnum.ROWS.getValue(),getBaseService().count(vo));
        return map;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> list(AdminBaseVo vo){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.SELECT.getConstant());
        Map<String,Object> resultMap = setPageDate(vo);
        return resultMap;
    }

    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(AdminBaseVo vo) throws InstantiationException, IllegalAccessException {
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.INSERT.getConstant());
        AjaxResult ajaxResult = new AjaxResult();
        T t = getBaseService().save(vo);
        ajaxResult.setData(t);
        return ajaxResult;
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(AdminBaseVo vo){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.UPDATE.getConstant());
        AjaxResult ajaxResult= new AjaxResult();
        getBaseService().update(vo);
        return ajaxResult;
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id")Long id){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.DELETE.getConstant());

        AjaxResult ajaxResult = new AjaxResult();
        getBaseService().delete(id);
        return ajaxResult;
    }

}
