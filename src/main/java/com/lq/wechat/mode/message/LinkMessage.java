package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ToUserName	接收方微信号
FromUserName	发送方微信号，若为普通用户，则是一个OpenID
CreateTime	消息创建时间
MsgType	消息类型，link
Title	消息标题
Description	消息描述
Url	消息链接
MsgId	消息id，64位整型
 * @author Administrator
 *
 */
@XStreamAlias("xml")
public class LinkMessage extends BaseMessage {
	
	private String Title;
	private String Description;
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
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	

}
