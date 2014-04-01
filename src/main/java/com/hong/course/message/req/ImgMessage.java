package com.hong.course.message.req;

/**
 * Created by Administrator on 2014/3/28 17:23.
 * 图片消息
 */
public class ImgMessage extends BaseMessage {
    private String PicUrl;  // 图片链接

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        this.PicUrl = picUrl;
    }
}
