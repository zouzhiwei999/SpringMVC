package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/15 23:17
 */
@Controller
//@RequestMapping("/hello")
public class RequestMappingTest {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(
            value = {"/success", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/getMappping")
    public String test() {
        return "success";
    }

    @RequestMapping(value = "testParams", params = {"user1name=admin", "password!=123456"})
    public String testParams() {
        return "success";
    }

    @RequestMapping("/a*a/testAnt")
    public String testAnt() {
        return "success";
    }
    @RequestMapping("/a?a/testAnt")
    public String testAnt1() {
        return "success";
    }
    @RequestMapping("/**/testAnt")
    public String testAnt2() {
        return "success";
    }

    @RequestMapping("/testPath/{id}/{name}")
    public String testPath(@PathVariable("id")Integer id, @PathVariable("name")String name){
        System.out.println("id:" + id + ",name:" + name);
        return "success";
    }

    @RequestMapping("/test_param")
    public String test_param(HttpServletRequest request){
        HttpSession session = request.getSession();
        return "test_param";
    }

    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",passwprd:" +password);
        return "success";
    }

    @RequestMapping("/param")
    public String param(
            @RequestParam(value = "user_name", required = false, defaultValue = "defaultName") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "host", required = true, defaultValue = "haha") String host,
            @CookieValue(value = "JSESSIONID", required = true) String session
            ){
        System.out.println("username" + username);
        System.out.println("password" + password);
        System.out.println("hobby" + Arrays.toString(hobby));
        System.out.println("host" + host);
        System.out.println("session" + session);
        return "success";
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
