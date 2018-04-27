package com.wl.blog.service.impl;

import com.wl.blog.dao.UserLogin;
import com.wl.blog.entity.User;
import com.wl.blog.service.UserLoginService;
import com.wl.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/6-15:37
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLogin userLogin;

    @Override
    public User userLogin(String email) {

        User user = userLogin.getByUserPasw(email);

        if (user == null) {
            return new User();
        } else {

            if (userLogin.updateUseStatus(user.getId())) {
                return user;
            }
            return user;
        }
    }

    @Override
    public User getUserById(int id) {
        User user = userLogin.getUserById(id);

        if (user == null) {
            return new User();
        } else {
            return user;
        }
    }
}
