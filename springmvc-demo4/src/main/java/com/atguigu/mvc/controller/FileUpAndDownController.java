package com.atguigu.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 3:10
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/downFile")
    public ResponseEntity<byte[]> downFile(HttpSession session) {
        FileInputStream fileInputStream = null;
        ResponseEntity<byte[]> responseEntity = null;
        try {
            ServletContext servletContext = session.getServletContext();

            String realPath = servletContext.getRealPath("/static/img/zhuxin.jpg");

            fileInputStream = new FileInputStream(realPath);

            byte[] bytes = new byte[fileInputStream.available()];

            fileInputStream.read(bytes);

            MultiValueMap<String, String> httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Disposition", "attachment;filename=zhuxin.jpg");

            HttpStatus ok = HttpStatus.OK;

            responseEntity = new ResponseEntity<>(bytes, httpHeaders, ok);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return responseEntity;
    }

    @RequestMapping("/upFile")
    public String upFile(HttpSession session, MultipartFile photo) throws IOException {

        String originalFilename = photo.getOriginalFilename();

        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        String s = UUID.randomUUID().toString();

        String filename = s + substring;

        ServletContext servletContext = session.getServletContext();
        String photo1 = servletContext.getRealPath("photo");
        File file = new File(photo1);
        if (!file.exists()){
            file.mkdir();
        }

        String finalpath = photo1 + File.separator + filename;
        photo.transferTo(new File(finalpath));
        return "success";

    }
}
