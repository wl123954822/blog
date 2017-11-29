package com.wl.blog.dao;

import com.wl.blog.Dto.BlogDto;
import com.wl.blog.Dto.BlogTimeDto;
import com.wl.blog.entity.Blog;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-13:54
 */
public interface BlogDao {

    boolean addBlog(Blog blog);

    List<BlogDto> listShow();

    List<BlogDto> listByTime(String createTime);

    //获取全部时间
    List<BlogTimeDto> getAllCreatTime();

    //获取显示的三个时间
    List<BlogTimeDto> getThreeCreatTime();

}
