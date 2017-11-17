package com.wl.blog.util;

import com.wl.blog.entity.Result;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/6-16:08
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setData(object);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public static Result erroe(){
        Result result=new Result();
        result.setCode(1);
        result.setMsg("错误");
        return result;
    }

}
