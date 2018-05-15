package com.wl.blog.Dto;

import com.wl.blog.entity.UserInfo;
import sun.dc.pr.PRError;

/**
 * 用户 类
 */
public class UserDto extends UserInfo {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
