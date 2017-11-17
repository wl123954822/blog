package com.wl.blog.controller;

import com.wl.blog.entity.User;
import com.wl.blog.service.UserLoginService;
import com.wl.blog.service.UserRegisterService;
import com.wl.blog.util.EncoderByMd5;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/3-16:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/register")
    public Map<String, Object> registerUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!RegExpUtil.isNull(user.getUsername() + "")) {
            String password = user.getPassword();
            User user1 = new User();
            user1.setPassword(EncoderByMd5.encoderByMd5f(password));
            user1.setEmail(user.getEmail());
            user1.setUsername(user.getUsername());
            Boolean ba = userRegisterService.userRegister(user1);
            if (ba) {
                map.put("status", "success");
                map.put("text", "注册成功");
            } else {
                map.put("status", "error");
                map.put("text", "注册失败,该邮箱重复注册");
            }
        } else {
            map.put("status", "error");
            map.put("text", "传参错误");
        }
        return map;
    }


    @RequestMapping("/login")
    public Map<String, Object> login(String email, String password, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!RegExpUtil.isNull(email + "") && !RegExpUtil.isNull(password + "")) {
            User user = userLoginService.userLogin(email);
            if (user.getId() == 0) {
                map.put("status", "error");
                map.put("text", "用户不存在");
            } else {
                if (EncoderByMd5.encoderByMd5f(password).equals(user.getPassword())) {
                    map.put("status", "success");
                    map.put("user", user.getUsername());
                    map.put("text", "登录成功");
                    //设置登录session
                    session.setAttribute("login",user.getId());
                } else {
                    map.put("status", "error");
                    map.put("text", "密码错误");
                }
            }
        } else {
            map.put("status", "error");
            map.put("text", "传参错误");
        }
        return map;
    }
}

