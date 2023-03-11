package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/23 3:18
 */
@Controller
public class HttpController {

    @RequestMapping("/testException")
    public String test() {
        System.out.println(1/0);
        System.out.println("test");
        System.out.println("hot-fix");
        System.out.println("master first");
        System.out.println("hot-fix second");
        System.out.println("ssh test");
        return "success";
    }

    @RequestMapping("/upfile")
    public String upfile(MultipartFile photo, HttpSession session) throws IOException {
        //获取文件的真实名
        String originalFilename = photo.getOriginalFilename();

        //剪切  点后缀,获取后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        //UUID
        String uuid = UUID.randomUUID().toString();

        //拼接到一起
        String filename = uuid + substring;

        //将照片方法放到指定的文件夹下，获取指定文件夹的真实保存路径
        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("photo");

        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        //最终全路径
        String finalName = path + File.separator + filename;
        photo.transferTo(new File(finalName));
        return "success";

    }
}
