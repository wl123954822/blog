package com.wl.blog.controller;

import com.wl.blog.entity.Like;
import com.wl.blog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/like")
@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/add")
    public Map<String,Object> addLike(Like like,String token){
        Integer userId = (Integer) redisTemplate.opsForValue().get(token);
        Map<String,Object> map = new HashMap<>();

        like.setUserId(userId);
        if (likeService.addLike(like)){
            Integer likeNum = likeService.likeNum(like.getBlogId());
            map.put("likeId",like.getId());
            map.put("likeNum",likeNum);
            map.put("status","success");
        }

        return map;
    }


    @RequestMapping("/likeNum")
    public Map<String ,Object> likeNum(int blogId){
        Map<String,Object> map = new HashMap<>();
        Integer likeNum = likeService.likeNum(blogId);
        map.put("likeNum",likeNum);
        return map;
    }
}
