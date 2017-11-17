package com.wl.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wl.blog.Dto.BlogDto;
import com.wl.blog.entity.Blog;
import com.wl.blog.entity.Click;
import com.wl.blog.entity.Label;
import com.wl.blog.service.BlogService;
import com.wl.blog.service.ClickService;
import com.wl.blog.service.LaberService;
import com.wl.blog.util.DateUtil;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-13:59*/


@RestController
@RequestMapping("/blog")
public class BlogController  {

    @Autowired
    private BlogService blogService;

    @Autowired
    private LaberService laberService;

    @Autowired
    private ClickService clickService;

    @RequestMapping("/add")
    public Map<String,Object> addBlog(Blog blog, @RequestParam("labelName") String labelName, HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
    Integer userId= (Integer) session.getAttribute("login");

        Label label=laberService.lablByName(labelName);
        blog.setLabelId(label.getLabelId());
    if (RegExpUtil.isNull(userId+"")){
            map.put("status","error");
            map.put("text","请登录");
        }else {

            blog.setUserId(userId);

            if (blogService.addBlog(blog)) {
                //首次创建博客，设置添加点击，默认为0
                int blogId=blog.getId();
                Click click=new Click();
                click.setBlogId(blogId);
                clickService.addClick(click);
                map.put("status", "success");
                map.put("text", "添加成功");
            }
            else {
                map.put("error", "添加失败");
            }
        }

        return map;
    }

    @RequestMapping("/list")
    public Map<String,Object> blogList( /*int pageSize,int pageIndex*/) throws ParseException {
        Map<String,Object> map=new HashMap<String, Object>();
        //开启分页
      //  PageHelper.startPage(pageIndex,pageSize);
        List<BlogDto> list=blogService.blogList();

        for (BlogDto blogDto : list) {
        //现获取从数据库中获得的时间，为String对象
        String blogCreat = blogDto.getCreateTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        //将字符串转换成Date对象
        Date date = sdf.parse(blogCreat);

        //在将转换后的data对象转换为String
        String a = DateUtil.newdate(date);

        blogDto.setCreateTime(a);
    }
       /* PageInfo<BlogDto> info=new PageInfo<BlogDto>(list);
        map.put("total",info.getTotal());*/
        map.put("list", list);

        return map;
}

        @RequestMapping("/listBycr")
        public Map<String,Object> listBycr(){
            Map<String,Object> map=new HashMap<String, Object>();
            List<BlogDto> list=blogService.blogLisByCr();
            map.put("list",list);
            return map;
        }
}
