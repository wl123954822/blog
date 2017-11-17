package com.wl.blog.util.Interface;

import java.lang.annotation.*;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/9-9:29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {

    String[] value() default {};

    String[] authorities() default {};

    String[] roles() default {};

}
