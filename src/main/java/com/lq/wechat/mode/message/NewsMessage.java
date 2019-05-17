package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;


/**
 * ToUserName	是	接收方帐号（收到的OpenID）
FromUserName	是	开发者微信号
CreateTime	是	消息创建时间 （整型）
MsgType	是	news
ArticleCount	是	图文消息个数，限制为8条以内
Articles	是	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
Title	否	图文消息标题
Description	否	图文消息描述
PicUrl	否	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
Url	否	点击图文消息跳转链接
 * @author Administrator
 *
 */
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {
	/**
	 *  消息条数
	 */
	private Integer ArticleCount;
	/**
	 * 多条图文消息
	 */
	private List<ItemMessage> Articles;
	public Integer getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}
	public List<ItemMessage> getArticles() {
		return Articles;
	}
	public void setArticles(List<ItemMessage> articles) {
		Articles = articles;
	}
    

}
