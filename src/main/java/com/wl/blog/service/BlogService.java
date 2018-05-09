package com.wl.blog.service;

import com.wl.blog.Dto.BlogDto;
import com.wl.blog.Dto.BlogTimeDto;
import com.wl.blog.entity.Blog;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-13:57
 */
public interface BlogService {

    boolean addBlog(Blog blog);

    List<BlogDto> blogList(int classificationId);

    List<BlogDto> blogLisByCr();

    List<BlogDto> blogListShow();

    List<BlogDto> blogListByTime(String createTime);

    //获取全部时间
    List<BlogTimeDto> getAllCreatTime();

    //获取显示的三个时间
    List<BlogTimeDto> getThreeCreatTime();

    //获取博客总记录数，分页
    int getBlogNum(int pageNum);

    //根据主键id获取博客
    List<BlogDto> blogListById(int blogId);

    //最热文章
    List<BlogDto> blogLiByHot();
}
