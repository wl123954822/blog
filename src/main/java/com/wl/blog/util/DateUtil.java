package com.wl.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Author: wl
 * @Description:将日期格式转化为yyyy-MM-dd格式
 * @Date:Create in 2017/11/16-16:26
 */
public class DateUtil {

    public static String newdate(Date date){

        SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
        return df.format(date);
    }
}
