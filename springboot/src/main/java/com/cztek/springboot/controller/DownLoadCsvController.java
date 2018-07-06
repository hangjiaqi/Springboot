package com.cztek.springboot.controller;

import com.cztek.springboot.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.tools.jar.Main;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.jar.JarFile;

@Controller
@RequestMapping("/download")
@Slf4j
public class DownLoadCsvController {

    @RequestMapping("/csv")
    public void DownLoadCsv(HttpServletResponse response) {
        String fileUrl = "/static/csvtemplate/";
        String fileName = "cookbook.csv";
        try {
            String temp = this.getClass().getResource("/").getPath();
            //String jarPath = Main.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            // 设置响应头
            //URL fileurl = this.getClass().getResource(fileUrl + fileName);
            //File file = new File(fileurl.getFile());
            //File file = new File(temp + fileUrl + fileName);
            //log.info("文件路径.............................." + file.getPath());

            InputStream in = this.getClass().getResourceAsStream(fileUrl + fileName);
            log.info("in:" + in.available());
            /*BufferedInputStream inputStream = null;
            if (in instanceof BufferedInputStream) {
                log.info("转换成功");
                inputStream = (BufferedInputStream) in;
            } else {
                log.info("转换失败");
                return;
            }*/
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
            response.setContentType("text/csv");

            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer, 0, buffer.length)) > 0) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
            in.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
