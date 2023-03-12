package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/19 2:46
 */
@Controller
public class JSPController {
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
