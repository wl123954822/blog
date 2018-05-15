package com.wl.blog.controller;

import com.wl.blog.Dto.UserDto;
import com.wl.blog.entity.UserInfo;
import com.wl.blog.service.UserInfoService;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/userInfo")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/getList")
    public Map<String,Object> getUser(@RequestParam("token") String token){
        Map<String,Object> map = new HashMap<>();
        Integer userId = (Integer) redisTemplate.opsForValue().get(token);
        if (userId == null){
            map.put("status", "error");
            map.put("text", "无用户登录");
        }else {
            UserDto userDtos = userInfoService.getList(userId);
            map.put("status", "status");
            map.put("userD", userDtos);
        }
        return map;
    }

    @RequestMapping("/upp")
    public Map<String,Object> upUser(UserInfo userInfo,@RequestParam("userName") String userName,@RequestParam("token") String token){
        Map<String,Object> map = new HashMap<>();
        Integer userId = (Integer) redisTemplate.opsForValue().get(token);
        userInfo.setUserId(userId);
        System.out.println(userName);
            if (userInfoService.updat(userInfo,userName)) {
                map.put("status", "success");
                map.put("text", "修改成功");
            }

        return map;
    }
}
