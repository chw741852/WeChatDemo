package com.hong.course.message.req;

/**
 * Created by Administrator on 2014/3/28 17:31.
 * 链接消息
 */
public class LinkMessage extends BaseMessage {
    private String Title;   // 标题
    private String Description;    // 描述
    private String Url;     // 链接

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
