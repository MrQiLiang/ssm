package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片消息
 *@author qi
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
