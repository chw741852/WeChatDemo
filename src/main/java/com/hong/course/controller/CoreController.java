package com.hong.course.controller;

import com.hong.course.service.CoreService;
import com.hong.course.util.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cai on 2014/3/27 15:16.
 */
@Controller
@RequestMapping("/core")
public class CoreController {
    @RequestMapping(value = "/weChat", method = RequestMethod.GET)
    public void getWeChat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
            System.out.println("from wexin.");
        }
        out.close();
        out = null;
    }

    /**
     * 处理微信服务器发来的消息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/weChat", method = RequestMethod.POST)
    public void postWeChat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接受消息、处理消息
        String respMessage = CoreService.processRequest(request);

//        respMessage = "<xml>\n" +
//                "  <ToUserName><![CDATA[orIm7t4t3l_maeqOl7_WIjZYynPc]]></ToUserName>\n" +
//                "  <FromUserName><![CDATA[gh_d63ecab347c7]]></FromUserName>\n" +
//                "  <CreateTime><![CDATA[1396250783806]]></CreateTime>\n" +
//                "  <MsgType><![CDATA[text]]></MsgType>\n" +
//                "  <FuncFlag><![CDATA[0]]></FuncFlag>\n" +
//                "  <Content><![CDATA[您发送的是文本消息！]]></Content>\n" +
//                "</xml>";
        System.out.println("返回消息：\n" + respMessage);
        // 响应消息
        PrintWriter out = response.getWriter();
        out.write(respMessage);
        out.close();
    }
}
