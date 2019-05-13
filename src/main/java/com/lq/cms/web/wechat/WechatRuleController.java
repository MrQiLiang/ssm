package com.lq.cms.web.wechat;

import com.lq.cms.service.WechatInfoService;
import com.lq.entity.WechatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *  微信公众号消息回复
 * Created by qi_liang on 2018/5/30.
 */
@Controller
@RequestMapping("/cms/wechat/rule")
public class WechatRuleController {

    @Autowired
    private WechatInfoService wechatInfoService;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView,Long wechatInfoId){
        if (wechatInfoId!=null){
            WechatInfo wechatInfo = wechatInfoService.findOne(wechatInfoId);
            modelAndView.addObject("wechatInfo",wechatInfo);
        }

        modelAndView.setViewName("cms/wechat/rule/index");
        return modelAndView;
    }



}
