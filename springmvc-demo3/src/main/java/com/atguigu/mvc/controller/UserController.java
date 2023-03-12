package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/19 22:36
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String allUser() {
        System.out.println("查询所有用户");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userById(@PathVariable("id") String id) {
        System.out.println("根据id查询所有用户" + "id:" + id);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView insertUser(String username, String password) {
        System.out.println("用户名" + username + ",密码" + password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ModelAndView updateUser(String username, String password) {
        System.out.println("修改用户,用户名" + username + ",密码" + password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
