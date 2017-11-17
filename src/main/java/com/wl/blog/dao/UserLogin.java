package com.wl.blog.dao;

import com.wl.blog.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/6-11:43
 */
public interface UserLogin {

    User getByUserPasw(@Param("email")String email);

    Boolean updateUseStatus(int id);



}
