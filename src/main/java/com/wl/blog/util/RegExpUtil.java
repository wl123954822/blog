package com.wl.blog.util;

/**
 * Created by panxiang on 2017-08-06.
 */
public class RegExpUtil {
    // 匹配空字符串
    public static final String FORMAT_NULL = "^\\s*|\\s*";

    // 比较字符串是否为空，若为空值返回true
    public static boolean isNull(String str) {
        boolean result = false;
        if (str == null || str.equals("null") || reWrite(str).length() == 0) {
            result = true;
        }
        return result;
    }

    // 去除字符串中的空格、回车、换行符、制表符等空白字符
    public static String reWrite(String str) {
        str = str.replaceAll(FORMAT_NULL, "");
        return str;
    }
}
