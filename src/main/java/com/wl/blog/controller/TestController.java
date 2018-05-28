package com.wl.blog.controller;

import com.wl.blog.dao.TestDao;
import com.wl.blog.entity.TesUser;
import com.wl.blog.entity.User;
import com.wl.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/27-17:02
 */

@RestController
public class TestController {

    //string类型
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //对象类型
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TestService testService;


    @RequestMapping("/hello")
    public String index() {
        //存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        String string = stringRedisTemplate.opsForValue().get("aaa");


        //存对象
        TesUser user = new TesUser(1, 2, "钢铁1");
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new TesUser(2, 2, "钢铁2");
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new TesUser(3, 2, "钢铁3");
        redisTemplate.opsForValue().set(user.getName(), user);

        TesUser user1 = (TesUser) redisTemplate.opsForValue().get("钢铁1");
        System.out.println(user1.getAge());
        System.out.println(((TesUser) redisTemplate.opsForValue().get("钢铁2")).getAge());
        System.out.println(((TesUser) redisTemplate.opsForValue().get("钢铁3")).getAge());


        return "Hello World";
    }

    @RequestMapping("/b")
    public Map<String, Object> ds() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TesUser> list = testService.list();
        System.out.println("【】【】【】【" + list.size());

        redisTemplate.opsForValue().set("list", list);
        map.put("list", list);
        return map;
    }

    @RequestMapping("/c")
    public Map<String, Object> sa() {
        Map<String, Object> map = new HashMap<String, Object>();

        TesUser tesUser = (TesUser) redisTemplate.opsForValue().get("listt");
        redisTemplate.delete("listt");

        List list2 = (List) redisTemplate.opsForValue().get("list");
        map.put("list新数量", list2);
        List list = new ArrayList();
        list.add(tesUser);
        map.put("list", list);
        return map;
    }

}
