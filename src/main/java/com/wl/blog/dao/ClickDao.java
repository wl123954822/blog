package com.wl.blog.dao;

import com.wl.blog.entity.Click;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: wl
 * @Description:点击增加
 * @Date:Create in 2017/11/16-14:51
 */
public interface ClickDao {

        boolean addClick(Click click);

        boolean updateClick(@Param("blogId") int blogId,@Param("clickNum") int clickNum);

}
