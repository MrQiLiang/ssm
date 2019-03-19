package com.lq.wechat.mode.message;

import com.lq.wechat.mode.message.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ToUserName	开发者微信号
FromUserName	发送方帐号（一个OpenID）
CreateTime	消息创建时间 （整型）
MsgType	image
PicUrl	图片链接（由系统生成）
MediaId	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
MsgId	消息id，64位整型
 */
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {
	/**
	 *  图片链接
	 */
	private String PicUrl;
	/**
	 *  素材ID（通过微信公众号提供的素材接口获得）
	 */
	private String MediaId;
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
