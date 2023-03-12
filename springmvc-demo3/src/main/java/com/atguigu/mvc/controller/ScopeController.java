package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/18 1:17
 */
@Controller
public class ScopeController {
//
//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }


    @RequestMapping("/testScopeSrevletAPI")
    public String testScopeSrevletAPI(HttpServletRequest request) {
        request.setAttribute("testScopeByServletAPI", "Hello,this is Servlet");

        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();

        //设置request域
        mav.addObject("testModelAndView", "ModelAndView");

        //绑定View
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testModel", "Hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map) {
        map.put("testMap", "Hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testModelMap", "Hello,ModelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSession", "Hello,Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication", "Hello,application");
        return "success";
    }
}
