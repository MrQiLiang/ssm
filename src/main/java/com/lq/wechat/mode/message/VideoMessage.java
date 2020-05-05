package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 视频消息
 * @author qi
 *
 */
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {
	/**
	 * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String MediaId;
	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
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
