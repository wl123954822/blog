package com.wl.blog.controller;

import com.wl.blog.entity.Blog;
import com.wl.blog.entity.Contentcls;
import com.wl.blog.service.BlogService;
import com.wl.blog.service.ContentclsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-16:38
 */
@RestController
@RequestMapping("/contentcls")
public class ContentclsController {

    @Autowired
    private ContentclsService contentclsService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/add")
    public Map<String,Object> contclss( Contentcls contentcls){
        Map<String,Object> map=new HashMap<String, Object>();

        if (contentclsService.addContentcls(contentcls)){

            map.put("status","成功");
        }
        return map;
    }
}
