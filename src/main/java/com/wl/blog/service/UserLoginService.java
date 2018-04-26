package com.wl.blog.service;

import com.wl.blog.entity.User;
import com.wl.blog.util.ResultUtil;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/6-15:36
 */
public interface UserLoginService {
    User userLogin(String email);

    User getUserById(int id);
}
