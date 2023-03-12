package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import com.atguigu.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/23 18:00
 */

@Controller
public class TestController {

    @RequestMapping("/for")
    public String for1(Model model) {
        model.addAttribute("testForwardScope", "转发定义域对象");
        return "forward:/success";
    }

    @RequestMapping("/red")
    public String red(Model model) {
        model.addAttribute("testRedirectScope", "重定向定义域对象");
        return "redirect:/success";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String allUser(Model model) {
        Collection<User> all = userDao.getAll();
        model.addAttribute("userList", all);
        return "user_list";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        userDao.delete(id);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(User user) {
        userDao.save(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")Integer id, Model model) {
        User user = userDao.get(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    @RequestMapping(value = ("/user"), method = RequestMethod.PUT)
    public String uoUser(User user) {
        userDao.save(user);
        return "redirect:/user";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestbody) {
        System.out.println(requestbody);
        return "success";
    }

    @RequestMapping("/testRequestBody1")
    public String testRequestBody(RequestEntity<String> entity) {
        System.out.println(entity.getHeaders());
        System.out.println(entity.getBody());
        return "success";
    }

    @RequestMapping("/responseBody")
    @ResponseBody
    public String responseBody() {
        return  "succeess";
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println(username + password);
        return "hello";

    }


}
