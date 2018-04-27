package com.wl.blog.dao;

import com.wl.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/3-16:36
 */
@Mapper
public interface UserRegister {
    /**
     * 用户注册
     */
    Boolean register(User user);

    Integer selectEmail(String email);
}
