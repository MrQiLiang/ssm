package com.lq.cms.web.wechat;

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

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.setViewName("cms/wechat/rule/index");
        return modelAndView;
    }

}
