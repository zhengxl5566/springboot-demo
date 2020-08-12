package com.zhengxl.thymeleafdemo.repository;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.repository
 * @author:郑晓龙
 * @createTime:2020/8/10 13:44
 * @version:1.0
 */
@Repository
public class FileRepository {

    private static final Map<String, String> FILE_NAME_MAP = new ConcurrentHashMap<>();

    @Value("${file.storage.path}")
    private String storagePath;

    /**
     * @param clientFileName 客户端上传时的文件名
     * @param inputStream    文件流
     * @return java.lang.String 返回保存后的服务端文件名
     * @description 保存文件
     * @author 郑晓龙
     * @createTime 2020/8/10 17:01
     **/
    public String saveFile(String clientFileName, InputStream inputStream) throws IOException {
        String suffix = clientFileName.substring(clientFileName.lastIndexOf('.'));
        // 生成一个服务端文件名防止因为重名造成的文件被覆盖
        String serverFileName = UUID.randomUUID().toString() + suffix;
        FileUtils.copyToFile(inputStream, new File(storagePath + serverFileName));
        // 保存服务端文件名和客户端文件名对照关系
        FILE_NAME_MAP.put(serverFileName, clientFileName);

        return serverFileName;
    }

    /**
     * @param serverFileName 服务端文件名
     * @return java.io.InputStream
     * @description 返回文件流，用完记得关闭流
     * @author 郑晓龙
     * @createTime 2020/8/10 15:48
     **/
    public InputStream getInputStream(String serverFileName) throws IOException {
        String absoluteFilePath = storagePath + serverFileName;
        return FileUtils.openInputStream(new File(absoluteFilePath));
    }

    /**
     * @param serverFileName
     * @return java.lang.String
     * @description 获取真实文件名，若没有则返回服务端文件名
     * @author 郑晓龙
     * @createTime 2020/8/10 16:12
     **/
    public String getClientFileName(String serverFileName) {
        if (!FILE_NAME_MAP.containsKey(serverFileName)) {
            return serverFileName;
        }
        return FILE_NAME_MAP.get(serverFileName);
    }
}
