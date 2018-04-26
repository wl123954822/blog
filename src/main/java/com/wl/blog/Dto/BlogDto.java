package com.wl.blog.Dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/16-15:11
 */
public class BlogDto implements Serializable {

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

    private String createTime;

    private Date updateTime;

    private int userId;

    private int blogId;

    private int clickNum;

    private int statusId;

    private String username;

    private String classificationName;

    private String labelName;

    private int blogClassId;

    private int bid;

    private int commentNum;

    private String suolueTu;

    public String getSuolueTu() {
        return suolueTu;
    }

    public void setSuolueTu(String suolueTu) {
        this.suolueTu = suolueTu;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    private String[] laberNamLis;

    public String[] getLaberNamLis() {
        return laberNamLis;
    }

    public void setLaberNamLis(String[] laberNamLis) {
        this.laberNamLis = laberNamLis;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBlogClassId() {
        return blogClassId;
    }

    public void setBlogClassId(int blogClassId) {
        this.blogClassId = blogClassId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
