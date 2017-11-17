package com.wl.blog.entity;

import java.io.Serializable;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/16-13:44
 */
public class Click implements Serializable {

    private int id;

    private int blogId;

    private int clickNum;

    private int statusId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
