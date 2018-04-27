package com.wl.blog.entity;

import java.io.Serializable;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/27-17:24
 */
public class TesUser implements Serializable {

    private Integer id;

    private String name;

    private long age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public TesUser(Integer id, long age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public TesUser(Integer id, String name, long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public TesUser() {
        super();
    }

    @Override
    public String toString() {
        return "TesUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

