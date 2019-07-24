package com.lq.wechat.web;

import com.lq.cms.emun.WechatInfoCertificationTypeEnum;
import com.lq.cms.service.WechatInfoService;
import com.lq.cms.service.WechatRuleService;
import com.lq.cms.service.WechatUserService;
import com.lq.code.util.StringUtil;
import com.lq.code.web.BaseController;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatUser;
import com.lq.wechat.mode.message.BaseMessage;
import com.lq.wechat.mode.message.ItemMessage;
import com.lq.wechat.mode.message.NewsMessage;
import com.lq.wechat.mode.message.TextMessage;
import com.lq.wechat.util.CheckUtil;
import com.lq.wechat.util.ConstantSet;
import com.lq.wechat.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qi
 * Created by qi on 2017/7/16.
 */
@Controller
@RequestMapping("/wechatApi")
public class  WechatController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatController.class);
    //消息类型
    public static final String WECHAT_MESSAGE_TYPE_KEY = "MsgType";
    //微信公众号openId
    public static final String WECHAT_OPENID_KEY = "ToUserName";
    //接收方账号
    public static final String WECHAT_USER_OPENID_KEY = "FromUserName";
    //用户-消息内容
    public static final String WECHAT_CONTENT_KEY = "Content";

    @Autowired
    private WechatInfoService wechatInfoService;
    @Autowired
    private WechatUserService wechatUserService;
    @Autowired
    private WechatRuleService wechatRuleService;

    @RequestMapping(method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String doget(String signature, String timestamp, String nonce, String echostr, String wechatOpenId, HttpServletResponse response) throws UnsupportedEncodingException {
        if (StringUtil.isNotNull(wechatOpenId)){
            //通过微信公众号名称查找公众号资料
            WechatInfo wechatInfo = wechatInfoService.getByOpenId(wechatOpenId);
            if (wechatInfo!=null){
                String token = wechatInfo.getToken();
                if (CheckUtil.checkSingatue(signature, timestamp, nonce,token)) {
                    try {
                        response.getWriter().write(echostr);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    return null;
                }
            }
        }
        return "Error Message";
    }

    @RequestMapping(method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String doPost(HttpServletRequest req){
        String message = null;
        try {
            Map<String, String> map = MessageUtil.xmlToMap(req);
            //消息类型
            String msgType = map.get(WECHAT_MESSAGE_TYPE_KEY);
            //微信公众号openId
            String wechatOpenId = map.get(WECHAT_OPENID_KEY);
            //接收方账号
            String openId = map.get(WECHAT_USER_OPENID_KEY);
            //微信公众号详情
            WechatInfo wechatInfo = wechatInfoService.getByOpenId(wechatOpenId);

            TextMessage text = new TextMessage();
            text.setFromUserName(wechatOpenId);
            text.setToUserName(openId);
            text.setMsgType(ConstantSet.MESSAGE_TYPE_TEXT);

            text.setCreateTime(System.currentTimeMillis());

            switch (msgType) {
                case ConstantSet.MESSAGE_TYPE_TEXT:
                    String content = map.get(WECHAT_CONTENT_KEY);
                    BaseMessage baseMessage = wechatRuleService.getByKeyworkdAndWechatInfoId(content,wechatInfo);
                    baseMessage.setCreateTime(System.currentTimeMillis());
                    baseMessage.setFromUserName(wechatOpenId);
                    baseMessage.setToUserName(openId);
                    message = MessageUtil.MessageToXml(baseMessage);
//                    if("1".equals(content)){
//                        NewsMessage newsMessage=new NewsMessage();
//                        List<ItemMessage> items=new ArrayList<>();
//                        ItemMessage item=new ItemMessage();
//                        item.setTitle("六弄咖啡馆");
//                        item.setDescription("两个人在爱在距离面前是否禁受考验？");
//                        String path = req.getContextPath();
//                        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
//                        item.setPicUrl("https://img3.doubanio.com/view/photo/l/public/p2367455902.webp");
//                        item.setUrl("http://www.iqiyi.com/v_19rr95j3vc.html?vfm=2008_aldbd");
//                        items.add(item);
//                        newsMessage.setArticles(items);
//                        newsMessage.setArticleCount(1);
//                        newsMessage.setCreateTime(System.currentTimeMillis());
//                        newsMessage.setFromUserName(wechatOpenId);
//                        newsMessage.setMsgType(ConstantSet.MESSAGE_TYPE_NEW);
//                        newsMessage.setToUserName(openId);
//                        message = MessageUtil.MessageToXml(newsMessage);
//                    } else{
//                        text.setContent("您发送的消息是：" + content);
//                        message = MessageUtil.MessageToXml(text);
//                    }
                    break;
                case ConstantSet.MESSAGE_TYPE_IMAGE:

                    text.setContent("您发送的消息是：" + "图片");
                    message = MessageUtil.MessageToXml(text);
                    break;
                case ConstantSet.MESSAGE_TYPE_VIDEO:
                    text.setContent("您发送的消息是：" + "视频");
                    message = MessageUtil.MessageToXml(text);
                    break;
                case ConstantSet.MESSAGE_TYPE_SHORTVIDEO:
                    text.setContent("您发送的消息是：" + "小视频");
                    message = MessageUtil.MessageToXml(text);
                    break;
                case ConstantSet.MESSAGE_TYPE_VOICE:
                    text.setContent("您发送的消息是：" + "语音");
                    message = MessageUtil.MessageToXml(text);
                    break;
                case ConstantSet.MESSAGE_TYPE_LINK:
                    text.setContent("您发送的消息是：" + "链接");
                    message = MessageUtil.MessageToXml(text);
                    break;
                case ConstantSet.MESSAGE_TYPE_LOCATION:
                    text.setContent("您发送的消息是：" + "位置");
                    message = MessageUtil.MessageToXml(text);
                    break;
                case ConstantSet.MESSAGE_TYPE_EVENT:
                    String event = map.get("Event");
                    switch (event) {
                        case ConstantSet.EVENT_TYPE_SUBSCRIBE:
                            LOGGER.info("微信公众号关注事件："+wechatInfo.getWechatName());
                            //公众号在认证的情况下才可以获取用户信息
                            if (WechatInfoCertificationTypeEnum.CERTIFICATION_YES.getValue().equals(wechatInfo.getCertification())) {
                                WechatUser wechatUser = wechatUserService.saveWechatUser(openId, wechatInfo);
                            }

                            break;
                        case ConstantSet.EVENT_TYPE_UNSUBSCRIBE:
                            ;
                            break;
                        case ConstantSet.EVENT_TYPE_CLICK:
                            //自定义菜单点击事件KEY值
                            String eventKey = map.get(ConstantSet.EVENT_CLICK_KEY);

                            ;
                            break;
                        default:
                            break;
                    }

                    break;

                default:
                    text.setContent("您发送的消息是：" + "无法理解");
                    message = MessageUtil.MessageToXml(text);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

}
