package com.wl.blog.dao;

import com.wl.blog.entity.TesUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/28-14:43
 */
@Mapper
public interface TestDao {

    List<TesUser> list();
}
