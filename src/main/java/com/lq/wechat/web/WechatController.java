package com.lq.wechat.web;

import com.lq.cms.service.WechatInfoService;
import com.lq.code.web.BaseController;
import com.lq.entity.WechatInfo;
import com.lq.wechat.mode.message.ItemMessage;
import com.lq.wechat.mode.message.NewsMessage;
import com.lq.wechat.mode.message.TextMessage;
import com.lq.wechat.util.CheckUtil;
import com.lq.wechat.util.ConstantSet;
import com.lq.wechat.util.MessageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by qi on 2017/7/16.
 */
@Controller
@RequestMapping("/wechatApi")
public class  WechatController extends BaseController {

    @Autowired
    private WechatInfoService wechatInfoService;


    private static Logger logger = Logger.getLogger(WechatController.class);

    @RequestMapping(method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String doget(String signature,String timestamp,String nonce,String echostr){


        if (CheckUtil.checkSingatue(signature, timestamp, nonce)) {

            return echostr;
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
            String msgType = map.get("MsgType");
            //微信公众号openId
            String toUserName = map.get("ToUserName");
            //接收方账号
            String fromUserName = map.get("FromUserName");
            //微信公众号详情
            WechatInfo wechatInfo = wechatInfoService.getByOpenId(toUserName);

            TextMessage text = new TextMessage();
            text.setFromUserName(toUserName);
            text.setToUserName(fromUserName);
            text.setMsgType(ConstantSet.MESSAGE_TYPE_TEXT);

            text.setCreateTime(System.currentTimeMillis());
            switch (msgType) {
                case ConstantSet.MESSAGE_TYPE_TEXT:
                    String content = map.get("Content");


                    if("1".equals(content)){
                        NewsMessage newsMessage=new NewsMessage();
                        List<ItemMessage> items=new ArrayList<>();
                        ItemMessage item=new ItemMessage();
                        item.setTitle("六弄咖啡馆");
                        item.setDescription("两个人在爱在距离面前是否禁受考验？");
                        String path = req.getContextPath();
                        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
                        item.setPicUrl(basePath+"/img/testImg.jpg");
                        item.setUrl("http://www.iqiyi.com/v_19rr95j3vc.html?vfm=2008_aldbd");
                        items.add(item);
                        newsMessage.setArticles(items);
                        newsMessage.setArticleCount(1);
                        newsMessage.setCreateTime(System.currentTimeMillis());
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setMsgType(ConstantSet.MESSAGE_TYPE_NEW);
                        newsMessage.setToUserName(fromUserName);
                        message = MessageUtil.MessageToXml(newsMessage);
                    } else{
                        text.setContent("您发送的消息是：" + content);
                        message = MessageUtil.MessageToXml(text);
                    }
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
                            ;
                            break;
                        case ConstantSet.EVENT_TYPE_UNSUBSCRIBE:
                            ;
                            break;
                        case ConstantSet.EVENT_TYPE_CLICK:
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
