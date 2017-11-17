package com.wl.blog.entity;

import java.io.Serializable;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-16:28
 */
public class Contentcls implements Serializable {

    private int id;

    private int blogClassId;

    private int classificationId;

    @Override
    public String toString() {
        return "Contentcls{" +
                "id=" + id +
                ", blogClassId=" + blogClassId +
                ", classificationId=" + classificationId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogClassId() {
        return blogClassId;
    }

    public void setBlogClassId(int blogClassId) {
        this.blogClassId = blogClassId;
    }

    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }
}
