package com.zhengxl.thymeleafdemo.service.impl;

import com.zhengxl.thymeleafdemo.repository.FileRepository;
import com.zhengxl.thymeleafdemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

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

    @Autowired
    FileRepository fileRepository;

    @Override
    public String saveInputStream(String clientFileName, InputStream inputStream) throws IOException {
        return fileRepository.saveFile(clientFileName,inputStream);

    }

    @Override
    public InputStream getInputStream(String serverFileName) throws IOException {
        return fileRepository.getInputStream(serverFileName);
    }

    @Override
    public String getClientFileName(String serverFileName) {
        return fileRepository.getClientFileName(serverFileName);
    }
}
