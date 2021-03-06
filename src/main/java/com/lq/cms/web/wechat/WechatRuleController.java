package com.lq.cms.web.wechat;

import com.alibaba.fastjson.JSON;
import com.lq.cms.emun.WechatKeywordMatchinTypeEnum;
import com.lq.cms.emun.WechatRuleReplyTypeEnum;
import com.lq.cms.service.WechatInfoService;
import com.lq.cms.service.WechatRuleService;
import com.lq.cms.vo.WechatRuleVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.StringUtil;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatKeyword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 *  微信公众号消息回复
 * Created by qi_liang on 2018/5/30.
 * @author qi
 */
@Controller
@RequestMapping("/cms/wechat/rule")
public class WechatRuleController {

    public static final Logger LOGGER = LoggerFactory.getLogger(WechatRuleController.class);

    @Autowired
    private WechatInfoService wechatInfoService;
    @Autowired
    private WechatRuleService wechatRuleService;


    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView,Long wechatInfoId){
        if (wechatInfoId!=null){
            WechatInfo wechatInfo = wechatInfoService.findOne(wechatInfoId);
            modelAndView.addObject("wechatInfo",wechatInfo);
        }
        List<WechatRuleVo> wechatRules = wechatRuleService.findByWechatInfoId(wechatInfoId);
        modelAndView.addObject("wechatRules",wechatRules);
        Map<Integer,String> wechatKeywordMatchinTypeMap = WechatKeywordMatchinTypeEnum.getEnumMap();
        modelAndView.addObject("wechatKeywordMatchinTypeMap",wechatKeywordMatchinTypeMap);
        Map<Integer,String> wehcatRuleReplyTypeMap = WechatRuleReplyTypeEnum.getEnumMap();
        modelAndView.addObject("wehcatRuleReplyTypeMap",wehcatRuleReplyTypeMap);
        modelAndView.setViewName("cms/wechat/rule/index");
        return modelAndView;
    }

    /**
     *  保存消息回复规则
     * @param vo
     * @param keywordListStr 关键字集合（json字符串）
     * @param messageListStr 消息集合（json字符串）
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    public Object save(WechatRuleVo vo,String keywordListStr,String messageListStr){
        AjaxResult ajaxResult = new AjaxResult();
        if (StringUtil.isNotNull(keywordListStr)) {
            List<WechatKeyword> wechatKeywordList = JSON.parseArray(keywordListStr, WechatKeyword.class);
            vo.setWechatKeywordList(wechatKeywordList);
        }
        if (StringUtil.isNotNull(messageListStr)){
            List<Long> messageIds = JSON.parseArray(messageListStr, Long.class);
            vo.setMessageIds(messageIds);
        }
        wechatRuleService.saveRule(vo);

        return ajaxResult;
    }

    /**
     * 更新回复规则
     * @param vo
     * @param keywordListStr
     * @param messageListStr
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public AjaxResult update(WechatRuleVo vo,String keywordListStr,String messageListStr){
        if (StringUtil.isNotNull(keywordListStr)) {
            List<WechatKeyword> wechatKeywordList = JSON.parseArray(keywordListStr, WechatKeyword.class);
            vo.setWechatKeywordList(wechatKeywordList);
        }
        if (StringUtil.isNotNull(messageListStr)){
            List<Long> messageIds = JSON.parseArray(messageListStr, Long.class);
            vo.setMessageIds(messageIds);
        }
        wechatRuleService.updateRule(vo);

        return AjaxResult.getSuccessInstance();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public AjaxResult delete(Long id){
        AjaxResult ajaxResult = new AjaxResult();
        wechatRuleService.deleteWechatRuleById(id);
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/getWechatRuleById")
    public Object getWechatRuleById(Long wechatRuleId){
        AjaxResult ajaxResult = new AjaxResult();
        WechatRuleVo wechatRuleVo = wechatRuleService.getWechatRuleVoById(wechatRuleId);
        ajaxResult.setData(wechatRuleVo);
        return ajaxResult;
    }



}
