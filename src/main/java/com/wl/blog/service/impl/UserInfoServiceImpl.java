package com.wl.blog.service.impl;

import com.wl.blog.Dto.UserDto;
import com.wl.blog.dao.UserInfoDao;
import com.wl.blog.dao.UserRegister;
import com.wl.blog.entity.UserInfo;
import com.wl.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserRegister userRegister;

    @Override
    public UserDto getList(int userId) {
        return userInfoDao.getListByUserId(userId);
    }

    @Override
    public boolean updat(UserInfo userInfo,String userName) {
        userRegister.updateUserName(userName,userInfo.getUserId());
        return userInfoDao.updateUserInfo(userInfo);
    }
}
