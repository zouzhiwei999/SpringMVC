package com.atguigu.mvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/23 9:49
 */
@Controller
public class HttpController1 {

    @RequestMapping(value = {"/a?a/success", "/a*a/success", "/**/success"})
    public String success() {
        return "success";
    }

    @RequestMapping("/success/{username}/{password}")
    public String test(@PathVariable("username")String username, @PathVariable("password")String passwword) {
        System.out.println("username:" + username + ",password:" + passwword);
        return "success";
    }

    @PostMapping("/test")
    public String test(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);
        return "success";
    }

    @PostMapping("/test1")
    public String test1(String username, String password) {

        System.out.println(username + ":" + password);
        return "success";
    }

    @PostMapping("/test2")
    public String test2(
            @RequestParam(value = "username", required = true, defaultValue = "zzw")String username,
            @RequestParam(value = "password", required = false, defaultValue = "0")String password
    ) {
        System.out.println(username + ":" + password);
        return "success";
    }



    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testscope", "年后");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model, String username, String password) {
        model.addAttribute("username1", username);
        model.addAttribute("password1", password);
        return "success";
    }

    @RequestMapping("/testMap")
    public String testModel(Map<String, String> map, String username, String password) {
        map.put("username2", username);
        map.put("password2", password);
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap, String username, String password) {
        modelMap.addAttribute("username3", username);
        modelMap.addAttribute("password3", password);
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session, String username, String password) {
        session.setAttribute("username4", username);
        session.setAttribute("password4", password);
        System.out.println(username + password);
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session, String username, String password) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("username5", username);
        servletContext.setAttribute("password5", password);
        return "success";
    }





}
