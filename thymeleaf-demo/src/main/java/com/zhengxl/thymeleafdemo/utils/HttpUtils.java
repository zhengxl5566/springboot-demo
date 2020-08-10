package com.zhengxl.thymeleafdemo.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
        // 获取 agent 信息，统一转换为小写方便后续对比
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        String downLoadFileName;
        // 微软浏览器
        if (agent.contains("msie") || agent.contains("trident") || agent.contains("edge")) {
            downLoadFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString())
                    .replaceAll("\\+", "%20");
        }
        // 火狐浏览器
        else if (agent.contains("firefox")) {
            downLoadFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString())
                    .replaceAll("\\+", "%20");
        }
        // safari 浏览器
        else if (agent.contains("firefox")) {
            downLoadFileName = "";
        }
        // Chrome 等其他浏览器
        else {
            downLoadFileName = new String(fileName.getBytes(), StandardCharsets.ISO_8859_1);
        }

        return downLoadFileName;
    }
}
