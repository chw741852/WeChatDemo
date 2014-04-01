package com.hong.course.message.resp;

/**
 * Created by Cai on 2014/3/28 17:56 17:57.
 * 音乐model
 */
public class Music {
    private String Title;   // 名称
    private String Description;    // 描述
    private String MusicUrl;   // 音乐链接
    private String HQMusicUrl; // 高质量音乐链接，WIFI环境优先使用该链接播放

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

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }
}
