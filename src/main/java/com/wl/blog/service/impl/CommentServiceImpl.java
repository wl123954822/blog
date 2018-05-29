package com.wl.blog.service.impl;

import com.wl.blog.Dto.CommentDto;
import com.wl.blog.dao.CommentDao;
import com.wl.blog.entity.Comment;
import com.wl.blog.service.CommentService;
import com.wl.blog.util.DateUtil;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public boolean addComment(Comment comment) {
        comment.setCreateTime(DateUtil.yymsfm(new Date()));
        return commentDao.addComment(comment);
    }

    @Override
    public boolean deleteComment(int id) {
        if (RegExpUtil.isNull(id + "") && RegExpUtil.isNull(id + "")) {
            return false;
        } else {
            return commentDao.deleteCommentById(id);
        }
    }

    @Override
    public List<CommentDto> listByPid(int blogId) {
        return commentDao.getLlistByPid(blogId);
    }

    @Override
    public int countNum(int blogId) {
        int pid = 0;
        return commentDao.commentNum(pid, blogId);
    }

    @Override
    public int isUser(int id) {
        return commentDao.isUser(id);
    }
}
