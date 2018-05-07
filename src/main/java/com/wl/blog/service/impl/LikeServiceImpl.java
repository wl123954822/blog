package com.wl.blog.service.impl;

import com.wl.blog.dao.LikeDao;
import com.wl.blog.entity.Like;
import com.wl.blog.service.LikeService;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;


    @Override
    public boolean addLike(Like like) {
     Integer likeStatus = likeDao.getLikeStatusByUserId(like.getUserId(),like.getBlogId());
       if (RegExpUtil.isNull(likeStatus+"")||likeStatus==0){
           return  likeDao.addLike(like);
       }
        return false;
    }

    @Override
    public Integer likeNum(int blogId) {
        int userStatus=1;
        return likeDao.getLikeNum(userStatus,blogId);
    }
}
