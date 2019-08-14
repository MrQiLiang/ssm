package com.lq.wechat.mode.template;

import java.util.Map;

/**
 * 微信公众号模版消息构造器
 * 默认实现类：WechatTemplateConcreteBuilder
 * @author qi
 */
public interface WechatTemplateBuilder {

    WechatTemplate builder();

    WechatTemplateBuilder setTouser(String touser);

    WechatTemplateBuilder setTemplate_id(String templateId);

    WechatTemplateBuilder setUrl(String url);

    WechatTemplateBuilder setMiniprogram(WechatTemplateMiniprogram miniprogram);

    WechatTemplateBuilder setMiniprogram(String appid, String pagepath);

    WechatTemplateBuilder setData(Map<String, Object> data);

    WechatTemplateBuilder setFirst(String value);

    WechatTemplateBuilder setFirst(String value, String color);

    WechatTemplateBuilder appendKeyWord(String value);

    WechatTemplateBuilder appendKeyWord(String value, String color);

    WechatTemplateBuilder setRemark(String value);

    WechatTemplateBuilder setRemark(String value, String color);

}
