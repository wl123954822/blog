package com.wl.blog.dao;

import com.wl.blog.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeDao {

      boolean addLike(Like like);

      Integer getLikeStatusByUserId(@Param("userId") int userId,@Param("blogId") int blogId);

      Integer getLikeNum(@Param("userStatus") int userStatus,@Param("blogId") int blogId);
}
