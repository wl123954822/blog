package com.wl.blog.controller;

import com.wl.blog.entity.Click;
import com.wl.blog.service.ClickService;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/16-15:05
 */
@RestController
@RequestMapping("/click")
public class ClickController {

    @Autowired
    private ClickService clickService;


    @RequestMapping("/update")
    public Map<String, Object> addClick(@RequestParam("blogId") int blogId,
                                        @RequestParam("clickNum") int clickNum,
                                        HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer userId = (Integer) session.getAttribute("login");
        if (RegExpUtil.isNull(userId + "")) {
            map.put("status", "未登录");
        } else {
            int newClick = clickNum + 1;
            if (clickService.updateClick(blogId, newClick)) {
                map.put("status", "success");
                map.put("text", "更改成功");
            }
        }

        return map;

    }

}
