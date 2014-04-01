package com.hong.course.message.resp;

/**
 * Created by Administrator on 2014/3/28 17:56.
 * 响应音乐消息
 */
public class MusicMessage extends BaseMessage {
    private Music Music;    // 音乐

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        this.Music = music;
    }
}
