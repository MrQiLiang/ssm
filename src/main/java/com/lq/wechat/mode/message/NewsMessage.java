package com.lq.wechat.mode.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;


/**
 *
 * @author qi
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
