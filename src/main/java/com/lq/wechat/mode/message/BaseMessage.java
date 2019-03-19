package com.lq.wechat.mode.message;

/**
 *  被动消息回复父类
 */
public class BaseMessage {
	/**
	 * 接收方openId
	 */
	private String ToUserName;
	/**
	 *  开发者账号(微信公众号openId)
	 */
	private String FromUserName;
	/**
	 * 创建时间
	 */
	private Long CreateTime;
	/**
	 * 消息类型
	 */
	private String MsgType;
	/**
	 * 消息id，64位整型
	 */
	private String MsgId;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}


}
