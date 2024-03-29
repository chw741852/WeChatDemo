package com.hong.course.service;

import com.hong.course.message.resp.TextMessage;
import com.hong.course.util.MessageUtil;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Cai on 2014/3/31 13:23.
 *
 * 核心服务类
 */
public class CoreService {
    public static String processRequest(HttpServletRequest request) {
        String respMessage = null;

        // 默认返回的文本消息内容
        String respContent = "请求处理异常，请稍后尝试！";

        // xml请求解析
        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            System.out.println("接受的消息是：“" + requestMap.get("Content") + "”");
            // 发送方帐号（open_id)
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "您发送的是文本消息！";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理消息！";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {    // 事件推送
                // 事件类型
                String eventType = requestMap.get("Event");

                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {   // 订阅
                    respContent = "谢谢您的关注！";
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 自定义菜单权没有开放，暂不处理该类消息
                }
            }

            textMessage.setContent(respContent);
            respMessage = MessageUtil.textMessageToXml(textMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}
