package com.wl.blog.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/8-14:49
 */
public class Blog implements Serializable {

    private int id;
    //标题
    private String title;
    //内容
    private String content;
    //标签
    private int labelId;
    //分类
    private int classificationId;
    //摘要
    private String abstractContent;

    private Date createTime;

    private Date updateTime;

    private int userId;

    private String suolueTu;

    public String getSuolueTu() {
        return suolueTu;
    }

    public void setSuolueTu(String suolueTu) {
        this.suolueTu = suolueTu;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", labelId=" + labelId +
                ", classificationId=" + classificationId +
                ", abstractContent='" + abstractContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
