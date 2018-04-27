package com.wl.blog.dao;

import com.wl.blog.Dto.LaberDto;
import com.wl.blog.entity.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wl
 * @Description:标签
 * @Date:Create in 2017/11/13-16:39
 */
@Mapper
public interface LabelDao {

    boolean insertLaber(Label label);

    Label labetByName(String labelName);

    List<Label> labelList();

    List<LaberDto> laberSet();
}
