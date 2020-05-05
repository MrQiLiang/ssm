package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 小视频消息
 * @author qi
 *
 */
@XStreamAlias("xml")
public class ShortvideoMessage extends BaseMessage {
	/**
	 * 视频消息媒体id
	 */
	private String MediaId;
	/**
	 * 视频消息缩略图的媒体id
	 */
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
