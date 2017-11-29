package com.wl.blog.Dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/24-16:06
 */
public class BlogTimeDto implements Serializable {

    private int id;

    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogTimeDto{" +
                "id=" + id +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
