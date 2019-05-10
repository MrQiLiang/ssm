package com.lq.cms.web.wechat;

import com.lq.cms.emun.WechatMessageTypeEnum;
import com.lq.cms.service.AdminBaseService;
import com.lq.cms.service.WechatMessageService;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.cms.web.AdminBaseController;
import com.lq.entity.WechatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *   微信公众号消息管理后台控制类
 */
@Controller
@RequestMapping("/cms/wechat/message")
public class WechatMessageController extends AdminBaseController<WechatMessage,WechatMessageVo> {

    @Autowired
    private WechatMessageService wechatMessageService;

    @RequestMapping("/index")
    public String index(){

        return "cms/wechat/message/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id){
        if (id!=null){
            WechatMessage wechatMessage = wechatMessageService.findOne(id);
            model.addAttribute("wechatMessage",wechatMessage);
        }
        Map<String,String> emunMap = WechatMessageTypeEnum.getEnumMap();
        model.addAttribute("wechatMessageTypeMap",emunMap);
        return "cms/wechat/message/edit";
    }



    @Override
    public AdminBaseService getBaseService() {

        return wechatMessageService;
    }

    @Override
    public String getIndexUrl() {

        return "/cms/wechat/message/index";
    }
}
