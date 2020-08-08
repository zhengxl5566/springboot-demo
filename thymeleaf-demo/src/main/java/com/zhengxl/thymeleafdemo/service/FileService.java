package com.zhengxl.thymeleafdemo.service;

import org.springframework.web.multipart.MultipartFile;

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
     * @description 保存文件
     * @param file 上传的文件
     * @return 保存的文件名
     * @author 郑晓龙
     * @createTime 2020/8/8 10:43
     **/
    String save(MultipartFile file) throws IOException;
    /**
     * @description 根据文件名获取文件
     * @param fileName
     * @return 文件输入流
     * @author 郑晓龙
     * @createTime 2020/8/8 10:44
     **/
    InputStream get(String fileName) throws IOException;

}
