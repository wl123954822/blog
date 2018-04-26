package com.wl.blog.service.impl;

import com.wl.blog.Dto.LaberDto;
import com.wl.blog.dao.LabelDao;
import com.wl.blog.entity.Label;
import com.wl.blog.service.LaberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/13-16:42
 */
@Service
public class LaberServiceImpl implements LaberService {

    @Autowired
    private LabelDao labelDao;


    @Override
    public boolean insertLaber(Label label) {
        return labelDao.insertLaber(label);
    }

    @Override
    public Label lablByName(String labelName) {
        return labelDao.labetByName(labelName);
    }

    @Override
    public List<Label> labelList() {
        return labelDao.labelList();
    }

    @Override
    public List<LaberDto> laberSet() {
        return labelDao.laberSet();
    }
}
