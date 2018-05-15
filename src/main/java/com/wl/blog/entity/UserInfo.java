package com.wl.blog.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private int id;

    private int userId;

    private String address;

    private String phone;

    private String timage;

    private String contant;

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }
}
