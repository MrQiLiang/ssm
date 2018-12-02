package com.lq.cms.web.sys;

/**
 * Created by qi_liang on 2018/2/24.
 */

import com.lq.cms.service.SysLogService;
import com.lq.cms.vo.SysLogVo;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志控制类
 */
@Controller
@RequestMapping("cms/log")
public class LogController {

    private static Logger logger = Logger.getLogger(LogController.class);


    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/index")
    @RequiresPermissions("/cms/log/index:SELECT")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("cms/sys/log/index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("/cms/log/index:SELECT")
    public Object list(SysLogVo vo){
        Map<String,Object> map=new HashMap();
        map.put("total",sysLogService.count(vo));
        map.put("rows",sysLogService.findListPage(vo));
        return map;
    }
}
