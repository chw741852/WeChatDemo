package com.hong.course.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


/**
 * Created by Administrator on 2014/3/28 15:21.
 *
 * 请求效验工具类
 */
public class SignUtil {
    // 与接口配置中Token保持一致
    private static String token = "wxCourse";

    /**
     * 验证签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] {token, timestamp, nonce};
        // 将 token, timestamp, nonce 3个参数进行字典表排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String s:arr) {
            content.append(s);
        }

        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha-1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byte2Str(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 将sha1加密后的字符串与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     * @param bytes
     * @return
     */
    private static String byte2Str(byte[] bytes) {
        String s = "";
        for (byte b:bytes) {
            s += byte2HexStr(b);
        }

        return s;
    }

    /**
     * 将字节转换为十六进制字符串
     * @param b
     * @return
     */
    private static String byte2HexStr(byte b) {
        char[] digit =  {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tmpArr = new char[2];
        tmpArr[0] = digit[(b >>> 4) & 0X0F];
        tmpArr[1] = digit[b & 0X0F];

        String s = new String(tmpArr);

        return s;
    }
}
