package com.wl.blog.service;

import com.wl.blog.entity.Click;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/16-15:03
 */
public interface ClickService {

    boolean addClick(Click click);

    boolean updateClick(int blogId, int clickNum);
}
