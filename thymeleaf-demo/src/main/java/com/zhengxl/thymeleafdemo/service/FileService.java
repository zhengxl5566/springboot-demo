package com.zhengxl.thymeleafdemo.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.service
 * @author:郑晓龙
 * @createTime:2020/8/8 10:40
 * @version:1.0
 */
public interface FileService {

    /**
     * @param clientFileName 客户端上传的文件名
     * @param inputStream    输入流
     * @return java.lang.String 服务端保存的文件名
     * @description
     * @author 郑晓龙
     * @createTime 2020/8/10 16:05
     **/
    String saveInputStream(String clientFileName, InputStream inputStream) throws IOException;

    /**
     * @param serverFileName 服务端文件名
     * @return 文件输入流
     * @description 根据文件名获取文件
     * @author 郑晓龙
     * @createTime 2020/8/8 10:44
     **/
    InputStream getInputStream(String serverFileName) throws IOException;

    /**
     * @param serverFileName 服务端文件名
     * @return java.lang.String 客户端文件名
     * @description 根据服务端文件名获取客户端文件名
     * @author 郑晓龙
     * @createTime 2020/8/10 16:09
     **/
    String getClientFileName(String serverFileName);

}
