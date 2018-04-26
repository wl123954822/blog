package com.wl.blog.Dto;

import java.io.Serializable;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/29-11:33
 */
public class ClassificationDto implements Serializable {

    private int classificationId;

    private String classificationName;

    private int classificationIdStatus;

    private int count;

    @Override
    public String toString() {
        return "ClassificationDto{" +
                "classificationId=" + classificationId +
                ", classificationName='" + classificationName + '\'' +
                ", classificationIdStatus=" + classificationIdStatus +
                ", count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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
