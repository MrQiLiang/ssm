package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ToUserName	开发者微信号
FromUserName	发送方帐号（一个OpenID）
CreateTime	消息创建时间 （整型）
MsgType	语音为voice
MediaId	语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
Format	语音格式，如amr，speex等
MsgID	消息id，64位整型
 * @author Administrator
 *
 */
@XStreamAlias("xml")
public class VoicemMessage extends BaseMessage {
	private String  MediaId;
	private String  Format;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}

}
