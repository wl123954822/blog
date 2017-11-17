package com.wl.blog.service.impl;

import com.wl.blog.dao.ClickDao;
import com.wl.blog.entity.Click;
import com.wl.blog.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/16-15:04
 */
@Service
public class ClickServiceImpl implements ClickService {

    @Autowired
    private ClickDao clickDao;



    @Override
    public boolean addClick(Click click) {
        return clickDao.addClick(click);
    }

    @Override
    public boolean updateClick(int blogId, int clickNum) {
        return clickDao.updateClick(blogId, clickNum);
    }
}
