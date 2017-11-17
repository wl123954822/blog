package com.wl.blog.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/6-10:53
 * 对注册的密码进行加密
 */
public class EncoderByMd5 {

    public static String encoderByMd5f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder=new BASE64Encoder();
        //加密后的字符串
        String newStr=base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
    }
