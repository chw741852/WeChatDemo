package com.hong.course.message.req;

/**
 * Created by Cai on 2014/3/28 17:05.
 *
 * 消息基类（普通用 -> 公众帐号）
 */

public class BaseMessage {
    private String ToUserName;    // 开发者微信号
    private String FromUserName;    // 发送方帐号
    private long CreateTime;    // 消息创建时间
    private String MsgType;     // 消息类型（test/image/location/link）
    private long MsgId;         // 消息ID

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
