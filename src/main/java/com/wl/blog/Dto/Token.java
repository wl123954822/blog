package com.wl.blog.Dto;

import java.io.Serializable;

/**
 * 用户登录 token,保存用户登录信息{用户名，用户session}
 */
public class Token implements Serializable {

    private String userName;

    private int session;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }
}
