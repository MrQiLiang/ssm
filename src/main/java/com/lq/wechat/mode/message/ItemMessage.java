package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 多文本消息-选项
 * @author qi
 */
@XStreamAlias("item")
public class ItemMessage {
	/**
	 * 标题
	 */
	private String Title;
	/**
	 * 说明
	 */
	private String Description;
	/**
	 * 图片链接
	 */
	private String PicUrl;
	/**
	 * 跳转链接
	 */
	private String Url;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	

}
