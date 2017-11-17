package com.wl.blog.entity;

import java.io.Serializable;

/**
 * @Author: wl
 * @Description: 分类
 * @Date:Create in 2017/11/8-15:04
 */
public class Classification implements Serializable {

    private int classificationId;

    private String classificationName;

    private int classificationIdStatus;


    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public int getClassificationIdStatus() {
        return classificationIdStatus;
    }

    public void setClassificationIdStatus(int classificationIdStatus) {
        this.classificationIdStatus = classificationIdStatus;
    }
}
