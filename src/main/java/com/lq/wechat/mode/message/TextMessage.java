package com.lq.wechat.mode.message;

import com.lq.wechat.mode.message.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  被动回复-文本消息
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
	/**
	 *  回复消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
