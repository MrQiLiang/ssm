package com.lq.wechat.mode.template;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/27.
 */
public class WechatTemplateConcreteBuilder implements WechatTemplateBuilder {

    //默认颜色
    public static final String DEFAULT_COLORD = "#173177";
    private WechatTemplate wechatTemplate;
    private Map<String,Object> data;
    private int index = 1;

    public WechatTemplateConcreteBuilder(){
        wechatTemplate = new WechatTemplate();
        data = new HashMap();
    }

    @Override
    public WechatTemplate builder() {
        wechatTemplate.setData(data);
        return wechatTemplate;
    }

    @Override
    public WechatTemplateBuilder setTouser(String touser) {
        wechatTemplate.setTouser(touser);
        return this;
    }

    @Override
    public WechatTemplateBuilder setTemplate_id(String templateId) {
        wechatTemplate.setTemplate_id(templateId);
        return this;
    }

    @Override
    public WechatTemplateBuilder setUrl(String url) {
        wechatTemplate.setUrl(url);
        return this;
    }

    @Override
    public WechatTemplateBuilder setMiniprogram(WechatTemplateMiniprogram miniprogram) {
        wechatTemplate.setMiniprogram(miniprogram);
        return this;
    }

    @Override
    public WechatTemplateBuilder setMiniprogram(String appid, String pagepath) {
        WechatTemplateMiniprogram wechatTemplateMiniprogram = new WechatTemplateMiniprogram();
        wechatTemplateMiniprogram.setAppid(appid);
        wechatTemplateMiniprogram.setPagepath(pagepath);
        wechatTemplate.setMiniprogram(wechatTemplateMiniprogram);
        return this;
    }

    @Override
    public WechatTemplateBuilder setData(Map<String, Object> data) {
        wechatTemplate.setData(data);
        return this;
    }

    @Override
    public WechatTemplateBuilder setFirst(String value) {
        setFirst(value,DEFAULT_COLORD);
        return this;
    }

    @Override
    public WechatTemplateBuilder setFirst(String value, String color) {
        WechatTemplateData wechatTemplateData = new WechatTemplateData();
        wechatTemplateData.setValue(value);
        wechatTemplateData.setColor(color);
        data.put("first",wechatTemplateData);
        return this;
    }

    @Override
    public WechatTemplateBuilder appendKeyWord(String value) {
        appendKeyWord(value,DEFAULT_COLORD);
        return null;
    }

    @Override
    public WechatTemplateBuilder appendKeyWord(String value, String color) {
        WechatTemplateData wechatTemplateData = new WechatTemplateData();
        wechatTemplateData.setValue(value);
        wechatTemplateData.setColor(color);
        data.put("keyword"+index,wechatTemplateData);
        index++;
        return this;
    }

    @Override
    public WechatTemplateBuilder setRemark(String value) {

        setRemark(value,DEFAULT_COLORD);

        return this;
    }

    @Override
    public WechatTemplateBuilder setRemark(String value, String color) {
        WechatTemplateData wechatTemplateData = new WechatTemplateData();
        wechatTemplateData.setValue(value);
        wechatTemplateData.setColor(color);
        data.put("remark",wechatTemplateData);
        return this;
    }
}
