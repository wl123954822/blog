package com.wl.blog.service;

import com.wl.blog.Dto.BlogDto;
import com.wl.blog.entity.Blog;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-13:57
 */
public interface BlogService  {

    boolean addBlog(Blog blog);

    List<BlogDto> blogList();

    List<BlogDto> blogLisByCr();
}
