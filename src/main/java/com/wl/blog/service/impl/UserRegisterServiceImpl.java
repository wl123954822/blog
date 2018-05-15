package com.wl.blog.service.impl;

import com.wl.blog.dao.UserInfoDao;
import com.wl.blog.dao.UserRegister;
import com.wl.blog.entity.User;
import com.wl.blog.entity.UserInfo;
import com.wl.blog.service.UserRegisterService;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/3-16:44
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserRegister userRegister;
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Boolean userRegister(User user) {
        //TODO
        // 判断有无注册
        Integer integer = userRegister.selectEmail(user.getEmail());

        if (RegExpUtil.isNull(integer + "")) {
           if (userRegister.register(user)){
               UserInfo userInfo = new UserInfo();
               userInfo.setUserId(user.getId());
               userInfoDao.addUserInfo(userInfo);
               return true;
           }
        }
        return false;
    }
}
