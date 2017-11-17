package com.wl.blog.service;

import com.wl.blog.entity.Label;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/13-16:41
 */
public interface LaberService {

    boolean insertLaber(Label label);

    Label lablByName(String labelName);

    List<Label> labelList();
}
