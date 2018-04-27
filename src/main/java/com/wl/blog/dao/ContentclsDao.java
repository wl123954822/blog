package com.wl.blog.dao;

import com.wl.blog.entity.Contentcls;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: wl
 * @Description:博客表和分类的关联表
 * @Date:Create in 2017/11/14-16:29
 */
@Mapper
public interface ContentclsDao {

    boolean addContent(Contentcls contentcls);
}
