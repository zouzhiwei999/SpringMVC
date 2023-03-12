package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/19 1:21
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf() {
        return "success";
    }

    @RequestMapping("/testInternalResourceView")
    public String testInternalResourceView() {
        return "forward:/testThymeleaf";
    }

    @RequestMapping("/testRedirectView")
    public String testRedirectView() {
        return "redirect:/testThymeleaf";
    }
}
