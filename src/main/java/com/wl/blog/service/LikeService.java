package com.wl.blog.service;

import com.wl.blog.entity.Like;

public interface LikeService {

       boolean addLike(Like like);

       Integer likeNum(int blogId);
}
