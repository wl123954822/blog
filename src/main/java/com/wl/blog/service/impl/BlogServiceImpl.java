package com.wl.blog.service.impl;

import com.wl.blog.Dto.BlogDto;
import com.wl.blog.Dto.BlogTimeDto;
import com.wl.blog.dao.BlogDao;
import com.wl.blog.dao.BlogListDao;
import com.wl.blog.dao.ClassificationDao;
import com.wl.blog.dao.ContentclsDao;
import com.wl.blog.entity.Blog;
import com.wl.blog.entity.Contentcls;
import com.wl.blog.service.BlogService;
import com.wl.blog.service.ClassificationService;
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

    @Autowired
    private ContentclsDao contentclsDao;

    @Override
    public boolean addBlog(Blog blog) {
        Contentcls contentcls = new Contentcls();
        if (blogDao.addBlog(blog)){
            contentcls.setBlogClassId(blog.getId());
            contentcls.setClassificationId(blog.getClassificationId());
           if (contentclsDao.addContent(contentcls)){
            return true;
           }
        }
        return false;
    }

    @Override
    public List<BlogDto> blogList() {
        return blogListDao.blogList();
    }

    @Override
    public List<BlogDto> blogLisByCr() {
        return blogListDao.blogLiByCreate();
    }

    @Override
    public List<BlogDto> blogListShow() {
        return blogDao.listShow();
    }

    @Override
    public List<BlogDto> blogListByTime(String createTime) {
        return blogDao.listByTime(createTime);
    }

    @Override
    public List<BlogTimeDto> getAllCreatTime() {
        return blogDao.getAllCreatTime();
    }

    @Override
    public List<BlogTimeDto> getThreeCreatTime() {
        return blogDao.getThreeCreatTime();
    }

    @Override
    public int getBlogNum(int pageNum) {

        int blogNum = blogDao.getBolgNum();
        //判断有没有余数
        if (blogNum % pageNum==0){
            return blogNum/pageNum;
        }else {
            return blogNum/pageNum+1;
        }
    }

    @Override
    public List<BlogDto> blogListById(int blogId) {
        return blogListDao.getBlogList(blogId);
    }

    @Override
    public List<BlogDto> blogLiByHot() {
        return blogListDao.blogLiByHot();
    }


}
