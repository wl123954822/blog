package com.wl.blog.dao;

import com.wl.blog.Dto.BlogDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/16-15:15
 */
@Mapper
public interface BlogListDao {

    List<BlogDto> blogList();

    //最新文章
    List<BlogDto> blogLiByCreate();

    /**
     * 根据主键id查询
     *
     * @param blogId
     * @return
     */
    List<BlogDto> getBlogList(int blogId);

    //最热文章
    List<BlogDto> blogLiByHot();

    //分类查询
    List<BlogDto> listByCid(int classificationId);
}
