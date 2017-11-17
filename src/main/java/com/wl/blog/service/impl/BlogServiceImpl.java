package com.wl.blog.service.impl;

import com.wl.blog.Dto.BlogDto;
import com.wl.blog.dao.BlogDao;
import com.wl.blog.dao.BlogListDao;
import com.wl.blog.entity.Blog;
import com.wl.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-13:58
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private BlogListDao blogListDao;

    @Override
    public boolean addBlog(Blog blog) {
        return blogDao.addBlog(blog);
    }

    @Override
    public List<BlogDto> blogList() {
        return blogListDao.blogList();
    }

    @Override
    public List<BlogDto> blogLisByCr() {
        return blogListDao.blogLiByCreate();
    }
}
