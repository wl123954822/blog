package com.wl.blog.service;

import com.wl.blog.Dto.LaberDto;
import com.wl.blog.entity.Label;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/13-16:41
 */
public interface LaberService {

    boolean insertLaber(Label label);

    Label lablByName(String labelName);

    List<Label> labelList();

    List<LaberDto> laberSet();
}
