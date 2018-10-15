package com.lq.cms.web.wechat;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.WechatInfoService;
import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.entity.AjaxResult;
import com.lq.entity.WechatInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
        modelAndView.setViewName("cms/wechat/info/edit");
        return modelAndView;
    }

    @RequiresPermissions("/cms/wechat/info/index:SELECT")
    @ResponseBody
    @RequestMapping("/list")
    public Object list(WechatInfoVo vo){
        Map<String,Object> map=new HashMap();
        map.put("total",wechatInfoService.count(vo));
        map.put("rows",wechatInfoService.findListPage(vo));
        return map;
    }

    @RequiresPermissions("/cms/wechat/info/index:INSERT")
    @ResponseBody
    @RequestMapping("/save")
    public Object save(WechatInfoVo vo){
        Date nowTime = new Date();
        AjaxResult ajaxResult = new AjaxResult();
        WechatInfo wechatInfo = new WechatInfo();
        BeanUtils.copyProperties(vo,wechatInfo);
        wechatInfo.setCreateTime(nowTime);
        wechatInfo.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatInfoService.save(wechatInfo);
        return  ajaxResult;
    }

    @RequiresPermissions("/cms/wechat/info/index:UPDATE")
    @ResponseBody
    @RequestMapping("/update")
    public Object update(WechatInfoVo vo){
        Date nowTime = new Date();
        AjaxResult ajaxResult = new AjaxResult();
        WechatInfo wechatInfo = wechatInfoService.findOne(1L);
        BeanUtils.copyProperties(vo,wechatInfo);
        wechatInfoService.update(wechatInfo);
        return  ajaxResult;
    }

    @RequiresPermissions("/cms/wechat/info/index:DELETE")
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
