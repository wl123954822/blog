package com.wl.blog.service.impl;

import com.wl.blog.dao.TestDao;
import com.wl.blog.entity.TesUser;
import com.wl.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/28-15:15
 */
@Service
public class TesUserImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<TesUser> list() {
        return testDao.list();
    }
}
