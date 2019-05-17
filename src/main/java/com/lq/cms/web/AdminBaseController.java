package com.lq.cms.web;

import com.lq.cms.emun.PermissionTyepEnum;
import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.AdminBaseService;
import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.entity.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理后台 父类
 * 强封装，缺少扩展，不建议采用
 */
public abstract class AdminBaseController<T,V extends AdminBaseVo> {

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminBaseController.class);


    /**
     *  获取service
     * @return
     */
    public abstract AdminBaseService<T,V> getBaseService();

    /**
     *  管理后台url（用于权限控制）
     * @return
     */
     public abstract String getIndexUrl();

    public AdminDataGridParam<V> setPageDate(V vo){
        AdminDataGridParam<V> adminDataGridParam = new AdminDataGridParam<>();
        adminDataGridParam.setRows(getBaseService().findListPage(vo));
        adminDataGridParam.setTotal(getBaseService().count(vo));
        return adminDataGridParam;
    }

    @RequestMapping("/list")
    @ResponseBody
    public AdminDataGridParam<V> list(V vo){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.SELECT.getConstant());
        AdminDataGridParam<V> adminDataGridParam = setPageDate(vo);
        return adminDataGridParam;
    }

    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(V vo) throws InstantiationException, IllegalAccessException {
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.INSERT.getConstant());
        AjaxResult ajaxResult = new AjaxResult();
        T t = getBaseService().save(vo);
        ajaxResult.setData(t);
        return ajaxResult;
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(V vo){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.UPDATE.getConstant());
        AjaxResult ajaxResult= new AjaxResult();
        getBaseService().update(vo);
        return ajaxResult;
    }

    @GetMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(getIndexUrl()+":"+ PermissionTyepEnum.DELETE.getConstant());
        AjaxResult ajaxResult = new AjaxResult();
        getBaseService().delete(id);
        return ajaxResult;
    }

}
