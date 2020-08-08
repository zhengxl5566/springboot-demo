package com.zhengxl.thymeleafdemo.controller;

import com.zhengxl.thymeleafdemo.service.FileService;
import com.zhengxl.thymeleafdemo.service.impl.FileServiceImpl;
import com.zhengxl.thymeleafdemo.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @description:
 * @projectName:thymeleaf-demo
 * @see:com.zhengxl.thymeleafdemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/8 13:49
 * @version:1.0
 */
@RestController
public class DownloadController {
    @Autowired
    FileService fileService;
    @GetMapping("download")
    public String download(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        String realName = FileServiceImpl.fileNameMap.get(fileName);
        response.setHeader("Content-disposition",
                "attachment; filename=" + HttpUtils.getDownloadFileName(request,realName));
        InputStream inputStream = fileService.get(fileName);

        OutputStream outputStream = response.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        byte[] buff = new byte[1024];
        int bytesRead;
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }
        bos.flush();

        inputStream.close();

        return "下载成功";
    }
}
