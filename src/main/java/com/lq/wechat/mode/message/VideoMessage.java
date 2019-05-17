package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ToUserName	开发者微信号
FromUserName	发送方帐号（一个OpenID）
CreateTime	消息创建时间 （整型）
MsgType	视频为video
MediaId	视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
ThumbMediaId	视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
MsgId	消息id，64位整型
 * @author Administrator
 *
 */
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {
	private String MediaId;
	private String ThumbMediaId;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	

}
