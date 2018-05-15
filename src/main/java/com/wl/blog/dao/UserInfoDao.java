package com.wl.blog.dao;

import com.wl.blog.Dto.UserDto;
import com.wl.blog.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface UserInfoDao {

    /**
     * 用户详情，新增
     */
    boolean addUserInfo(UserInfo userInfo);

    /**
     * 获取用户详情
     */
    UserDto getListByUserId(int userId);

    boolean updateUserInfo(UserInfo userInfo);
}
