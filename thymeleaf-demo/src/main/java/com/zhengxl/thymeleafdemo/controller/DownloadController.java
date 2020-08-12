package com.zhengxl.thymeleafdemo.controller;

import com.zhengxl.thymeleafdemo.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @description: 文件下载Controller
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/8 13:49
 * @version:1.0
 */
@RestController
@RequestMapping("download")
public class DownloadController {

    @Autowired
    private FileService fileService;

    @GetMapping("test")
    public String test(String name) {
        return name;
    }

    @GetMapping("/downloadFile")
    public String download(String serverFileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

        String clientFileName = fileService.getClientFileName(serverFileName);
        String percentEncodedFileName = URLEncoder.encode(clientFileName, StandardCharsets.UTF_8.toString())
                .replaceAll("\\+", "%20");

        StringBuilder contentDispositionValue = new StringBuilder();
        contentDispositionValue.append("attachment; filename=")
                .append(percentEncodedFileName)
                .append(";")
                .append("filename*=")
                .append("utf-8''")
                .append(percentEncodedFileName);

        response.setHeader("Content-disposition",
                contentDispositionValue.toString());

        try (InputStream inputStream = fileService.getInputStream(serverFileName);
             OutputStream outputStream = response.getOutputStream()
        ) {
            IOUtils.copy(inputStream, outputStream);
        }

        return "OK!";
    }
}
