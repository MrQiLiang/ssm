package com.lq.cms.web.wechat;

import com.lq.cms.emun.WechatMessageTypeEnum;
import com.lq.cms.mode.AdminDataGridParam;
import com.lq.cms.service.WechatMessageService;
import com.lq.cms.vo.WechatMessageBo;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.Constant;
import com.lq.code.util.FileUtil;
import com.lq.code.util.StringUtil;
import com.lq.entity.WechatMessage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *   微信公众号消息管理后台控制类
 */
@Controller
@RequestMapping("/cms/wechat/message")
public class WechatMessageController {

    public static final Logger LOGGER = LoggerFactory.getLogger(WechatMessageController.class);

    public static final String INDEX_URL = "/cms/wechat/message/index";

    @Autowired
    private WechatMessageService wechatMessageService;

    @Value("${file.upload}")
    private String fileLoadPath;


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
            String filePath = upLoadFile(file);
            if(StringUtil.isNotNull(filePath)) {
                vo.setImageUrl(filePath);
            }
            vo.setUpdateTime(new Date());
            wechatMessageService.save(vo);
        return ajaxResult;
    }

    @RequiresPermissions(INDEX_URL+Constant.PERSSION_MARK+Constant.PERMISSION_UPDATE)
    @RequestMapping("/update")
    @ResponseBody
    public Object update(WechatMessageVo vo,@RequestParam(value = "file",required = false) MultipartFile file){
        AjaxResult ajaxResult = new AjaxResult();
        String filePath = upLoadFile(file);
        if (StringUtil.isNotNull(filePath)) {
            vo.setImageUrl(filePath);
        }
        vo.setUpdateTime(new Date());
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

    //内部方法 ，上传文件，并返回文件路径
    private String upLoadFile(MultipartFile multipartFile){
        String newFileName = null;
        if (multipartFile!=null && multipartFile.getSize()>0){
            UUID uuid = UUID.randomUUID();
            String fileType = FileUtil.fileFormat(multipartFile.getOriginalFilename());
            newFileName = "wechat/"+uuid.toString()+"."+fileType;
            File newFile = new File(fileLoadPath +newFileName);

            if (!newFile.exists()){
                newFile.mkdirs();
            }
            try {
                multipartFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newFileName;
    }

}
