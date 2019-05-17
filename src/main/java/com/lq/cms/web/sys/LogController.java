package com.lq.cms.web.sys;

/**
 * Created by qi_liang on 2018/2/24.
 */

import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.SysLogService;
import com.lq.cms.vo.SysLogVo;
import com.lq.code.util.Constant;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日志控制类
 */
@Controller
@RequestMapping("cms/log")
public class  LogController {

    private static Logger LOGGER = Logger.getLogger(LogController.class);

    public static final String INDEX_URL = "/cms/log/index";

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("cms/sys/log/index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_SELECT)
    public Object list(SysLogVo vo){
        AdminDataGridParam<SysLogVo> adminDataGridParam = new AdminDataGridParam<>();
        adminDataGridParam.setTotal(sysLogService.count(vo));
        adminDataGridParam.setRows(sysLogService.findListPage(vo));
        return adminDataGridParam;
    }
}
