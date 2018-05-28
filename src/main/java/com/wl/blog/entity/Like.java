package com.wl.blog.entity;

public class    Like  {

    private int id;

    private int likeNumb;

    private int userStatus;//默认没有登陆

    private int blogId;

    private int userId;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikeNumb() {
        return likeNumb;
    }

    public void setLikeNumb(int likeNumb) {
        this.likeNumb = likeNumb;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
