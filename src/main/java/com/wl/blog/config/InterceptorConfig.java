package com.wl.blog.config;

import Interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: wl
 * @Description:拦截器的配置
 * @Date:Create in 2017/11/8-15:23
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
    }
}
