package com.wl.blog.service;

import com.wl.blog.entity.User;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.swing.text.StyledEditorKit;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/3-16:41
 */
public interface UserRegisterService {

    Boolean userRegister(User user);


}
