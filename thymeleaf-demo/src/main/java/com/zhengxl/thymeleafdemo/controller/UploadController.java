package com.zhengxl.thymeleafdemo.controller;

import com.zhengxl.thymeleafdemo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private static final String INDEX_PAGE = "index";
    private static final String SUCCESS_PAGE = "success";

    @Autowired
    FileService fileservice;


    @GetMapping("/")
    public String upload() {
        return INDEX_PAGE;
    }

    @PostMapping("/uploadFile")
    public String add(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()) {
            return INDEX_PAGE;
        }
        String fileName = fileservice.save(file);

        model.addAttribute("fileName",fileName);
        return SUCCESS_PAGE;
    }

    @PostMapping("/uploadMultiFiles")
    public String uploadMultiFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        if (files.length <= 0) {
            return INDEX_PAGE;
        }
        for (MultipartFile file : files) {
            fileservice.save(file);
        }

        return SUCCESS_PAGE;
    }


}
