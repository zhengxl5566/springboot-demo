package com.zhengxl.thymeleafdemo.controller;

import com.zhengxl.thymeleafdemo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


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

    private final Logger logger = LoggerFactory.getLogger(UploadController.class);

    private final String INDEX_PAGE = "index";
    private final String SUCCESS_PAGE = "success";

    @Autowired
    FileService fileService;


    @GetMapping("/")
    public String upload() {
        return INDEX_PAGE;
    }

    @PostMapping("/uploadFile")
    public String add(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return INDEX_PAGE;
        }
        fileService.saveFile(file);

        return SUCCESS_PAGE;
    }

    @PostMapping("/uploadMultiFiles")
    public String uploadMultiFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length <= 0) {
            return INDEX_PAGE;
        }
        for (MultipartFile file : files) {
            fileService.saveFile(file);
        }

        return SUCCESS_PAGE;
    }

    @GetMapping("download")
    @ResponseBody
    public String download(String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");

        // 兼容IE
        String ie = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        // chrome、firefox
        String chrome = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        response.setHeader("Content-disposition",
                "attachment; filename=" + ie);
        InputStream inputStream = fileService.getFile(fileName);

        OutputStream outputStream = response.getOutputStream();

        BufferedInputStream bis = new BufferedInputStream(inputStream);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        byte[] buff = new byte[1024];
        int bytesRead;
        //每次读取缓存大小的流，写到输出流
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }
        bos.flush();

        // 大部分Web服务器都基于HTTP/1.1协议，会复用TCP连接。如果没有调用flush(),将导致缓冲区的内容无法及时发送到客户端
        outputStream.flush();

        return "下载成功";
    }


}
