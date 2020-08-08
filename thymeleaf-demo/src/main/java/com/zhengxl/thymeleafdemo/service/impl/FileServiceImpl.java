package com.zhengxl.thymeleafdemo.service.impl;

import com.zhengxl.thymeleafdemo.service.FileService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.service
 * @author:郑晓龙
 * @createTime:2020/8/7 13:47
 * @version:1.0
 */
@Service
public class FileServiceImpl implements FileService {
    Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    private final String STORAGE_PATH_PICTURE = "d:/upload/";
    public static final Map<String, String> fileNameMap = new ConcurrentHashMap<>();

    @Override
    public String save(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "";
        }
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));

        String fileName = UUID.randomUUID().toString() + suffix;
        String serverFilePath = STORAGE_PATH_PICTURE + fileName;
        File destDir = new File(serverFilePath);
        FileUtils.copyToFile(file.getInputStream(), destDir);
        fileNameMap.put(fileName,file.getOriginalFilename());

        return fileName;
    }

    @Override
    public InputStream get(String fileName) throws IOException {
        String targetFilePath = STORAGE_PATH_PICTURE + fileName;
        return FileUtils.openInputStream(new File(targetFilePath));
    }
}
