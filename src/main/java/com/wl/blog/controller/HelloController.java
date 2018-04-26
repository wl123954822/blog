package com.wl.blog.controller;

import com.wl.blog.util.Interface.Access;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/9-9:42
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
    //配置注解权限，允许身份为admin的人访问
    @Access(authorities = {"admin"})
    public String hello(HttpServletRequest request){

        return "Hello admin";
    }

    @RequestMapping("/a")
    public String a(HttpServletRequest request){
        request.getSession().setAttribute("role","admin");
        return "ads";
        //阿什顿
    }
}
