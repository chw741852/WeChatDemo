package com.hong.course.message.req;

/**
 * Created by Administrator on 2014/3/28 17:43.
 * 音乐消息
 */
public class VoiceMessage extends BaseMessage {
    private String MediaId;     // 媒体ID
    private String Format;      // 语音格式

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        this.Format = format;
    }
}
