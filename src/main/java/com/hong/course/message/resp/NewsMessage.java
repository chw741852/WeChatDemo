package com.hong.course.message.resp;

import java.util.List;

/**
 * Created by Cai on 2014/3/28 17:59.
 * 响应图文消息
 */
public class NewsMessage extends BaseMessage {
    private int ArticleCount;   // 图文消息数量，限制为10条以内
    private List<Article> Articles; // 多条图文消息，默认第一条为大图

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
