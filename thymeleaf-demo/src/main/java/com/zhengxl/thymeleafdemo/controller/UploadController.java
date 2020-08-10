package com.zhengxl.thymeleafdemo.controller;

import com.zhengxl.thymeleafdemo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/7 10:57
 * @version:1.0
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    private static final String PAGE_INDEX = "index";
    private static final String PAGE_SUCCESS = "upload-success";

    @Autowired
    FileService fileservice;

    /**
     * @param file
     * @param model
     * @return java.lang.String
     * @description 上传单个文件
     * @author 郑晓龙
     * @createTime 2020/8/10 17:02
     **/
    @PostMapping("/uploadFile")
    public String add(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()) {
            logger.error("上传的文件为空");
            return PAGE_INDEX;
        }
        String clientFilename = file.getOriginalFilename();
        String serverFileName = fileservice.saveInputStream(clientFilename, file.getInputStream());
        model.addAttribute("serverFileName", serverFileName);

        return PAGE_SUCCESS;
    }

    /**
     * @param files
     * @return java.lang.String
     * @description 上传多个文件
     * @author 郑晓龙
     * @createTime 2020/8/10 17:02
     **/
    @PostMapping("/uploadMultiFiles")
    public String uploadMultiFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        if (files.length <= 0) {
            logger.error("上传的文件为空");
            return PAGE_INDEX;
        }
        for (MultipartFile file : files) {
            String clientFilename = file.getOriginalFilename();
            String serverFileName = fileservice.saveInputStream(clientFilename, file.getInputStream());
        }

        return PAGE_SUCCESS;
    }
}
