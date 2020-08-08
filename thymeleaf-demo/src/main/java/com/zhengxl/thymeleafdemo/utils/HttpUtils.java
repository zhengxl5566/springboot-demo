package com.zhengxl.thymeleafdemo.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.utils
 * @author:郑晓龙
 * @createTime:2020/8/8 14:00
 * @version:1.0
 */
public class HttpUtils {
    public static String getDownloadFileName(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        String agent = request.getHeader("USER-AGENT");
        String downLoadFileName;
        // 微软浏览器
        if (agent.contains("MSIE") || agent.contains("Trident") || agent.contains("Edge")) {
            downLoadFileName = URLEncoder.encode(fileName, "utf-8")
                    .replaceAll("\\+", "%20");
        }
        // 其他浏览器
        else {
            downLoadFileName = new String(fileName.getBytes(), "ISO8859-1");
        }
        return downLoadFileName;
    }
}
