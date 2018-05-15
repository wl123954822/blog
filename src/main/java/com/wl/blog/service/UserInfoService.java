package com.wl.blog.service;

import com.wl.blog.Dto.UserDto;
import com.wl.blog.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserDto getList(int userId);

    boolean updat(UserInfo userInfo,String userName);
}
