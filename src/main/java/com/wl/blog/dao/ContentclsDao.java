package com.wl.blog.dao;

import com.wl.blog.entity.Contentcls;

/**
 * @Author: wl
 * @Description:博客表和分类的关联表
 * @Date:Create in 2017/11/14-16:29
 */
public interface ContentclsDao {

    boolean addContent(Contentcls contentcls);
}
