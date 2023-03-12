package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/21 19:43
 */

@Controller
public class HttpController {

    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    @RequestMapping("/requestEntity")
    public String requestEntity(RequestEntity<String> requestEntity) {
        System.out.println(requestEntity.getHeaders());
        System.out.println(requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/httpServletResponse")
    public void httpServletResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello,world");
    }

    @RequestMapping("/responseBody")
    @ResponseBody
    public String responseBody(){

        return "responseBody响应的内容";
    }

    @RequestMapping("/responseBodyJson")
    @ResponseBody
    public User responseBodyJson(){

        User tom = new User(1001, "Tom", "Tom@163.com", 18);
        return tom;
    }

    @RequestMapping("/responseAjax")
    @ResponseBody
    public String responseAjax(String username, String password){
        System.out.println(username + password);
        return "hello,ajax";
    }
}
