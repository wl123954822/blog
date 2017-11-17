package com.wl.blog.service.impl;

import com.wl.blog.dao.ContentclsDao;
import com.wl.blog.entity.Contentcls;
import com.wl.blog.service.ContentclsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-16:37
 */
@Service
public class ContentclsServiceImpl implements ContentclsService {

    @Autowired
    private ContentclsDao contentclsDao;

    @Override
    public boolean addContentcls(Contentcls contentcls) {
        return contentclsDao.addContent(contentcls);
    }
}
