package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 22:04
 */
@Controller
public class HttpController {

    @RequestMapping("/**/success")
    public String success() {
        return "success";
    }

    @RequestMapping("/testException")
    public String testException() {
        System.out.println(1/0);
        return "success";
    }
}
