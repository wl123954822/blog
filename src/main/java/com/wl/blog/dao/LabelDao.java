package com.wl.blog.dao;

import com.wl.blog.entity.Label;

import java.util.List;

/**
 * @Author: wl
 * @Description:标签
 * @Date:Create in 2017/11/13-16:39
 */
public interface LabelDao {

    boolean insertLaber(Label label);

    Label labetByName(String labelName);

    List<Label> labelList();

}
