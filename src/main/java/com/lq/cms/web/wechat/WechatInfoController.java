package com.lq.cms.web.wechat;

import com.lq.cms.emun.*;
import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.WechatInfoService;
import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.Constant;
import com.lq.entity.SysUser;
import com.lq.entity.WechatInfo;
import org.apache.shiro.SecurityUtils;
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
import java.util.Map;

/**微信公众号详情
 * Created by qi_liang on 2018/6/1.
 */
@Controller
@RequestMapping("/cms/wechat/info")
public class WechatInfoController {

    private static final String INDEX_URL = "/cms/wechat/info/index";


    @Autowired
    private WechatInfoService wechatInfoService;

    @RequestMapping("/index")
    public String index(){

        return "cms/wechat/info/index";
    }

    @RequestMapping("/edit")
    public ModelAndView edit(WechatInfoVo vo, ModelAndView modelAndView){
        if (vo!=null&&vo.getId()!=null) {
            WechatInfo wechatInfo = wechatInfoService.findOne(vo.getId());
            modelAndView.addObject("wechatInfo", wechatInfo);
        }
        Map<String,String> encodingTypeMap = WechatInfoEncodingTypeEnum.getEnumMap();
        modelAndView.addObject("encodingTypeMap",encodingTypeMap);
        Map<Integer,String> wechatInfoTypeMap = WechatInfoTypeEnum.getEnumMap();
        modelAndView.addObject("wechatInfoTypeMap",wechatInfoTypeMap);
        Map<Integer,String> wechatInfoCertificationTypeMap = WechatInfoCertificationTypeEnum.getEnumMap();
        modelAndView.addObject("wechatInfoCertificationTypeMap",wechatInfoCertificationTypeMap);
        modelAndView.setViewName("cms/wechat/info/edit");
        return modelAndView;
    }

    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_SELECT)
    @ResponseBody
    @RequestMapping("/list")
    public Object list(WechatInfoVo vo){
        AdminDataGridParam<WechatInfoVo> adminDataGridParam = new AdminDataGridParam();
        adminDataGridParam.setTotal(wechatInfoService.count(vo));
        adminDataGridParam.setRows(wechatInfoService.findListPage(vo));
        return adminDataGridParam;
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_INSERT)
    @ResponseBody
    @RequestMapping("/save")
    public Object save(WechatInfoVo vo){
        Date nowTime = new Date();
        Subject subject= SecurityUtils.getSubject();
        SysUser loginUser=(SysUser) subject.getPrincipal();
        AjaxResult ajaxResult = new AjaxResult();
        WechatInfo wechatInfo = new WechatInfo();
        BeanUtils.copyProperties(vo,wechatInfo);
        wechatInfo.setCreateTime(nowTime);
        wechatInfo.setCreateUserId(loginUser.getId());
        //公众号新增默认关闭回复
        wechatInfo.setOpenReply(WechatInfoOpenReplyTypeEnum.OPEN_ON.getValue());
        wechatInfo.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatInfoService.save(wechatInfo);
        return  ajaxResult;
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_UPDATE)
    @ResponseBody
    @RequestMapping("/update")
    public Object update(WechatInfoVo vo){
        AjaxResult ajaxResult = new AjaxResult();
        Subject subject= SecurityUtils.getSubject();
        SysUser loginUser=(SysUser) subject.getPrincipal();
        WechatInfo wechatInfo = wechatInfoService.findOne(vo.getId());
        BeanUtils.copyProperties(vo,wechatInfo);
        wechatInfo.setLastUpdateTime(new Date());
        wechatInfo.setUpdateUserId(loginUser.getId());
        wechatInfoService.update(wechatInfo);
        return  ajaxResult;
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_UPDATE)
    @ResponseBody
    @RequestMapping("/updateOpenReply")
    public Object updateOpenReply(Long wechatInfoId,Integer openReply){
        AjaxResult ajaxResult = new AjaxResult();
        Subject subject= SecurityUtils.getSubject();
        SysUser loginUser=(SysUser) subject.getPrincipal();
        WechatInfo wechatInfo = wechatInfoService.findOne(wechatInfoId);

        if (wechatInfo!=null){
            wechatInfo.setLastUpdateTime(new Date());
            wechatInfo.setUpdateUserId(loginUser.getId());
            wechatInfo.setOpenReply(openReply);
            wechatInfoService.update(wechatInfo);
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("更新失败！");
        }
        return ajaxResult;
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_DELETE)
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(WechatInfoVo vo){
        AjaxResult ajaxResult = new AjaxResult();
        if(vo != null && vo.getId() != null) {
            wechatInfoService.delete(vo.getId());
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("操作失败");
        }
        return ajaxResult;
    }

}
