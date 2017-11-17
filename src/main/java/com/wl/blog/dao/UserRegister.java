package com.wl.blog.dao;

import com.wl.blog.entity.User;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/3-16:36
 */
public interface UserRegister {
    /**
     * 用户注册
     */
    Boolean register(User user);

    Integer selectEmail(String email);
}
