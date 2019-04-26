package com.lq.cms.web;

import com.alibaba.fastjson.JSON;
import com.lq.cms.mode.MenusComposite;
import com.lq.cms.service.SysResourceService;
import com.lq.cms.service.SysUserService;
import com.lq.cms.vo.SysInfoVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.Constant;
import com.lq.code.util.DateUtil;
import com.lq.code.util.Md5Util;
import com.lq.code.util.jdbc.JdbcUtils;
import com.lq.code.util.jdbc.mode.DbInfo;
import com.lq.code.util.os.JvmUtil;
import com.lq.code.util.os.NetUtil;
import com.lq.code.util.os.OsUtil;
import com.lq.code.util.os.mode.JvmInfo;
import com.lq.code.util.os.mode.OsInfo;
import com.lq.entity.SysUser;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** 首页控制类
 * Created by qi on 2017/8/20.
 */
@Controller("CmsIndexController")
@RequestMapping("/cms")
public class IndexController {

    private static Logger LOGGER = Logger.getLogger(IndexController.class);

    @Autowired
    private SysResourceService sysResourceService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = {"/index",""})
    public ModelAndView toCmsIndix(ModelAndView modelAndView, HttpServletRequest request){
        Subject subject=SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser=(SysUser) subject.getPrincipal();
        List<MenusComposite> list = null;
        if (subject.hasRole(Constant.ROLE_ADMIN)) {
            list = sysResourceService.findAllMenusList(request);
        }else{
            list = sysResourceService.findMenusListBySysUserId(sysUser.getId(), request);

        }
        modelAndView.addObject("menusList",list);
        modelAndView.setViewName("cms/main/index");
        return  modelAndView;
    }

    @RequestMapping("/sysInfo")
    public ModelAndView toCmsInfo(ModelAndView modelAndView,HttpServletRequest request){
        SysInfoVo vo = new SysInfoVo();
        ServletContext context = request.getServletContext();
        String userIp = NetUtil.getIP();
        context.getServerInfo();
        DbInfo dbInfo = JdbcUtils.getDBInfo();
        OsInfo osInfo = OsUtil.getInfo();
        String serverIp = NetUtil.getIP();
        JvmInfo jvmInfo = JvmUtil.getInfo();
        vo.setDbInfo(dbInfo);
        vo.setUserIP(userIp);
        vo.setOsInfo(osInfo);
        vo.setSysIp(serverIp);
        vo.setJvmInfo(jvmInfo);
        vo.setServerInfo(context.getServerInfo());
        modelAndView.addObject("sysInfoVo",vo);
        modelAndView.setViewName("cms/info");
        return modelAndView;
    }

    @RequestMapping("/openTab")
    public ModelAndView toTab(ModelAndView modelAndView){
        modelAndView.setViewName("cms/main/tab");
        return modelAndView;
    }

    @RequestMapping("/updatePass")
    @ResponseBody
    public Object updatePass(String oldPass,String newPass){
        AjaxResult ajaxResult=new AjaxResult(true,"修改成功","");
        Subject subject=SecurityUtils.getSubject();
        SysUser sysUser=(SysUser) subject.getPrincipal();
        SysUser sysUser1= sysUserService.findByLoginNameAndPassword(sysUser.getLoginName(), oldPass);
        if (sysUser1!=null){
            sysUser1.setPassword(Md5Util.getMd5(newPass));
            sysUser1.setUpdateTime(new Date());
            sysUserService.update(sysUser1);
        }else{
            ajaxResult.setMsg("密码不正确");
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

}
