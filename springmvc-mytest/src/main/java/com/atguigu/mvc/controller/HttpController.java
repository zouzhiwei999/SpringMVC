package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/23 9:49
 */
@Controller
//@RequestMapping("/test")
public class HttpController {
    @RequestMapping("/")
    public String index() {
        return "index2";
    }

    @RequestMapping(value = {"/hello", "/hello1"},method = {RequestMethod.GET})
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = {"/hello"}, method = {RequestMethod.POST})
    public String hello1() {
        return "hello1";
    }

    @GetMapping("/helloGetMapping")
    public String helloGetMapping() {
        return "hello";
    }

    @PostMapping("/helloPostMapping")
    public String helloPostMapping() {
        return "hello1";
    }

    @PostMapping(value = {"/param"}, params = {"username=admin"})
    public String param() {
        return "param";
    }



}
