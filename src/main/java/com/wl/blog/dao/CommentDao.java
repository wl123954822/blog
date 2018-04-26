package com.wl.blog.dao;

import com.wl.blog.Dto.CommentDto;
import com.wl.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论
 */
public interface CommentDao {

    //添加评论
    boolean addComment(Comment comment);

    //删除评论
    boolean deleteCommentById(int id);

    //根据pid显示评论
    List<CommentDto> getLlistByPid(@Param("blogId") int blogId);

    int commentNum (@Param("pid") int pid,@Param("blogId") int blogId);
}
