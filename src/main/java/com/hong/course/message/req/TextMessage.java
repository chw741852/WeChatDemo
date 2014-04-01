package com.hong.course.message.req;

/**
 * Created by Cai on 2014/3/28 17:10.
 * 文本消息
 */
public class TextMessage extends BaseMessage {
    private String Content; // 消息内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
