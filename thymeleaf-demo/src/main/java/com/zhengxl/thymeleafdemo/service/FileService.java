package com.zhengxl.thymeleafdemo.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.service
 * @author:郑晓龙
 * @createTime:2020/8/7 13:47
 * @version:1.0
 */
@Service
public class FileService {
    Logger logger = LoggerFactory.getLogger(FileService.class);

    private final String STORAGE_PATH_PICTURE = "d:/tmp/picture/";
    private final String STORAGE_PATH_VIDEO = "d:/tmp/video/";
    private final String STORAGE_PATH_AUDIO = "d:/tmp/audio/";


    public String saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "";
        }
        UUID.randomUUID().toString();
        String substring = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));

        try {
            File destDir = new File(STORAGE_PATH_PICTURE + UUID.randomUUID().toString() + substring);
            FileUtils.copyToFile(file.getInputStream(), destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info(file.getOriginalFilename());
        return "";
    }

    public InputStream getFile(String fileName) throws IOException {
        String targetFilePath = "d:/tmp/picture/"+fileName;
        return FileUtils.openInputStream(new File(targetFilePath));
    }
}
