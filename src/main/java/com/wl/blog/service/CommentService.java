package com.wl.blog.service;

import com.wl.blog.Dto.CommentDto;
import com.wl.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 添加评论
     */
    boolean addComment(Comment comment);

    /**
     * 删除评论
     */
    boolean deleteComment(int id);

    /**
     * 根据pid显示评论
     */
    List<CommentDto> listByPid(int blogId);

    /**
     * 根据blogId查询评论数
     */
    int countNum(int blogId);
}
