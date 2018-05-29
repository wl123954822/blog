package com.wl.blog.controller;


import com.wl.blog.Dto.CommentDto;
import com.wl.blog.entity.Comment;
import com.wl.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/addComment")
    public Map<String, Object> addComment(String token, Comment comment) {
        Map<String, Object> map = new HashMap<>();
        //当前登录用户id
        Integer userId = (Integer) redisTemplate.opsForValue().get(token);
        comment.setCommentUserId(userId);
        //增加评论限制，自己不能回复自己
        if (comment.getPid() != 0 && comment.getPid() == userId) {
            map.put("status", "error");
            map.put("text", "不能评论自己");
        } else {
            if (commentService.addComment(comment)) {
                map.put("status", "success");
                map.put("text", "评论成功");
            }
        }
        return map;
    }


    @RequestMapping("/delete")
    public Map<String, Object> deleteComment(int id,String token) {
        Integer userId = (Integer) redisTemplate.opsForValue().get(token);
        Map<String, Object> map = new HashMap<>();

        if (commentService.isUser(id)==userId){
            if (commentService.deleteComment(id)) {
                map.put("status", "success");
                map.put("text", "删除成功");
            } else {
                map.put("status", "erroe");
                map.put("text", "删除失败");
            }
        }else {
            map.put("text","非本人无法删除");
        }

        return map;
    }

    @RequestMapping("/showByPid")
    public Map<String, Object> showByPid(int blogId) {
        Map<String, Object> map = new HashMap<>();
        List<CommentDto> list = commentService.listByPid(blogId);
        map.put("list", list);
        return map;
    }


    @RequestMapping("/getNum")
    public Map<String, Object> commentNum(int blogId) {
        Map<String, Object> map = new HashMap<>();
        int commentNum = commentService.countNum(blogId);
        map.put("commentNum", commentNum);
        return map;
    }
}
