package com.lq.cms.web.wechat;

import com.lq.cms.emun.WechatMessageTypeEnum;
import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.AdminBaseService;
import com.lq.cms.service.WechatMessageService;
import com.lq.cms.vo.WechatMessageBo;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.cms.web.AdminBaseController;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.Constant;
import com.lq.entity.SysUser;
import com.lq.entity.WechatMessage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 *   微信公众号消息管理后台控制类
 */
@Controller
@RequestMapping("/cms/wechat/message")
public class WechatMessageController {

    public static final String INDEX_URL = "/cms/wechat/message/index";

    @Autowired
    private WechatMessageService wechatMessageService;
    @Value("${file.upload}")
    private String FILE_LOAD_PATH;


    @RequestMapping("/index")
    public String index(){

        return "cms/wechat/message/index";
    }

    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_SELECT)
    @RequestMapping("/list")
    @ResponseBody
    public Object list(WechatMessageVo vo){
        AdminDataGridParam<WechatMessageVo> adminDataGridParam = new AdminDataGridParam<>();
        adminDataGridParam.setRows(wechatMessageService.findAllWechatMessageVo(vo));
        adminDataGridParam.setTotal(wechatMessageService.count(vo));
        return adminDataGridParam;
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id){
        if (id!=null){
            WechatMessage wechatMessage = wechatMessageService.findOne(id);
            model.addAttribute("wechatMessage",wechatMessage);
        }
        Map<Integer,String> emunMap = WechatMessageTypeEnum.getEnumMap();
        model.addAttribute("wechatMessageTypeMap",emunMap);
        return "cms/wechat/message/edit";
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_INSERT)
    @RequestMapping("/save")
    @ResponseBody
    public Object save(WechatMessageVo vo,@RequestParam(value = "file",required = false) MultipartFile file){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            wechatMessageService.save(vo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_UPDATE)
    @RequestMapping("/update")
    @ResponseBody
    public Object update(WechatMessageVo vo,@RequestParam(value = "file",required = false) MultipartFile file){
        AjaxResult ajaxResult = new AjaxResult();
        wechatMessageService.update(vo);
        return ajaxResult;
    }

    @RequiresPermissions(INDEX_URL+ Constant.PERSSION_MARK+Constant.PERMISSION_DELETE)
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(WechatMessage wechatMessage){
        AjaxResult ajaxResult=new AjaxResult();
        if (wechatMessage!=null&&wechatMessage.getId()!=null){
            wechatMessageService.delete(wechatMessage.getId());
        }
        return ajaxResult;
    }

    @RequestMapping("/findMessageDataList")
    @ResponseBody
    public Object findAll(WechatMessageVo wechatMessageVo){
        List<WechatMessageVo> wechatMessageVoList = wechatMessageService.findAllWechatMessageVo(wechatMessageVo);
        WechatMessageBo wechatMessageBo = new WechatMessageBo();
        wechatMessageBo.setWechatMessageVoList(wechatMessageVoList);
        wechatMessageBo.setWechatMessageCount(wechatMessageVoList.size());
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setData(wechatMessageBo);
       return ajaxResult;
    }

}
