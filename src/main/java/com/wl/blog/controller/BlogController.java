package com.wl.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.corba.se.spi.ior.ObjectKey;
import com.wl.blog.Dto.BlogDto;
import com.wl.blog.Dto.BlogTimeDto;
import com.wl.blog.entity.Blog;
import com.wl.blog.entity.Click;
import com.wl.blog.entity.Label;
import com.wl.blog.service.*;
import com.wl.blog.util.DateUtil;
import com.wl.blog.util.Interface.Access;
import com.wl.blog.util.RegExpUtil;
import net.sf.jsqlparser.statement.replace.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/14-13:59
 */


@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BlogService blogService;

    @Autowired
    private LaberService laberService;

    @Autowired
    private ClickService clickService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @RequestMapping("/add")
    public Map<String, Object> addBlog(@RequestParam("labelName") String labelName,
                                       @RequestParam("token") String token,
                                       Blog blog) {
        Map<String, Object> map = new HashMap<String, Object>();
        //创建博客的用户id
        Integer userId = (Integer) redisTemplate.opsForValue().get(token);
        Label label = new Label();
        label.setLabelName(labelName);
        if (laberService.insertLaber(label)) {
            blog.setLabelId(label.getLabelId());
            blog.setUserId(userId);
            if (blogService.addBlog(blog)) {
                //首次创建博客，设置添加点击，默认为0
                int blogId = blog.getId();
                Click click = new Click();
                click.setBlogId(blogId);
                clickService.addClick(click);
                map.put("status", "success");
                map.put("text", "添加成功");
            } else {
                map.put("error", "添加失败");
            }
            return map;
        }
        return map;
    }

    @RequestMapping("/list")
    public Map<String, Object> blogList(int pageSize,int pageNumber ,int classificationId) throws ParseException {

        Map<String, Object> map = new HashMap<String, Object>();
        //开启分页
         PageHelper.startPage(pageSize,pageNumber);
        List<BlogDto> list = blogService.blogList(classificationId);
        int page = blogService.getBlogNum(5);

        for (BlogDto blogDto : list) {
            //获取评论数
            int commentNum = commentService.countNum(blogDto.getBlogId());
            //获取点赞数
            int likeNum =likeService.likeNum(blogDto.getBlogId());

            blogDto.setLikeNum(likeNum);
            blogDto.setCommentNum(commentNum);
            //现获取从数据库中获得的时间，为String对象
            String blogCreat = blogDto.getCreateTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            //将字符串转换成Date对象
            Date date = sdf.parse(blogCreat);

            //在将转换后的data对象转换为String
            String a = DateUtil.newdate(date);

            blogDto.setCreateTime(a);
        }
        PageInfo<BlogDto> info = new PageInfo<>(list);
        map.put("total",info.getTotal());
        map.put("list",info.getList());
        //map.put("list", list);
        map.put("totaPage", page);
        return map;
    }

    @RequestMapping("/listBycr")
    public Map<String, Object> listBycr() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BlogDto> list = blogService.blogLisByCr();
        map.put("list", list);
        return map;
    }

    @RequestMapping("/listShow")
    public Map<String, Object> listShow() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BlogDto> list = blogService.blogListShow();
        map.put("total", 10);
        map.put("rows", list);
        return map;
    }


    @RequestMapping("/listByTime")
    public Map<String, Object> listTime(String createTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BlogDto> list = blogService.blogListByTime(createTime);
        map.put("total", 10);
        map.put("rows", list);
        return map;

    }

    @RequestMapping("/getAlTime")
    public Map<String, Object> getAlTime() throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BlogTimeDto> list = blogService.getAllCreatTime();

        for (BlogTimeDto blogTimeDto : list) {
            String blogTime = blogTimeDto.getCreateTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            //将字符串转换成Date对象
            Date date = sdf.parse(blogTime);

            //在将转换后的data对象转换为String
            String a = DateUtil.new2date(date);
            blogTimeDto.setCreateTime(a);
        }
        //set排序
        Set<BlogTimeDto> blogTimeDtos = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (BlogTimeDto blogTimeDto : list) {
            set.add(blogTimeDto.getCreateTime());
        }
        for (String s : set) {
            BlogTimeDto blogTimeDto = new BlogTimeDto();
            blogTimeDto.setCreateTime(s);
            blogTimeDtos.add(blogTimeDto);
        }
        map.put("newtemm", blogTimeDtos);
        map.put("list", list);
        return map;
    }

    @RequestMapping("/getThreeTime")
    public Map<String, Object> getThreeTime() throws ParseException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BlogTimeDto> list = blogService.getThreeCreatTime();
        for (BlogTimeDto blogTimeDto : list) {
            String blogTime = blogTimeDto.getCreateTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(blogTime);
            String a = DateUtil.new2date(date);

            blogTimeDto.setCreateTime(a);
        }
        Set<BlogTimeDto> blogTimeDtos = new HashSet<>();
        Set<String> set = new HashSet();
        for (BlogTimeDto blogTimeDto : list) {
            set.add(blogTimeDto.getCreateTime());
        }
        for (String s : set) {
            BlogTimeDto blogTimeDto = new BlogTimeDto();
            blogTimeDto.setCreateTime(s);
            blogTimeDtos.add(blogTimeDto);
        }

        map.put("newss", blogTimeDtos);


        map.put("list", list);
        return map;
    }

    /**
     * @param pageNum 分几页
     * @return
     */
    @RequestMapping("/total")
    public Map<String, Object> getPage(int pageNum) {
        Map<String, Object> map = new HashMap<>();

        int page = blogService.getBlogNum(pageNum);

        map.put("totaPage", page);

        return map;
    }


    @RequestMapping("/blogById")
    public Map<String, Object> getBlogById(int blogId) throws ParseException {
        Map<String, Object> map = new HashMap<>();

        List<BlogDto> blogDtos = blogService.blogListById(blogId);
        for (BlogDto blogDto : blogDtos) {
            //每次博客访问，算点击一次
            int clickNum = blogDto.getClickNum();
            int newClick = clickNum + 1;
            clickService.updateClick(blogId, newClick);
            //时间转换
            String time = blogDto.getCreateTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            //将字符串转换成Date对象
            Date date = sdf.parse(time);
            //在将转换后的data对象转换为String
            String a = DateUtil.newdate(date);
            //获取评论数
            int commentNum = commentService.countNum(blogDto.getBlogId());
            blogDto.setCommentNum(commentNum);

            blogDto.setCreateTime(a);
            String laberName = blogDto.getLabelName();
            String newlaberName = laberName.replaceAll("，", ",");
            String[] liberNlis = newlaberName.split(",");
            blogDto.setLaberNamLis(liberNlis);
        }

        map.put("text", "变更成功");
        map.put("list", blogDtos);

        return map;
    }


    @RequestMapping("/blogHot")
    public Map<String, Object> blogHotList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BlogDto> list = blogService.blogLiByHot();
        map.put("list", list);
        return map;
    }
}
