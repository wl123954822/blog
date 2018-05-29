package Interceptor;

import com.wl.blog.util.Interface.Access;
import com.wl.blog.util.RegExpUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/9-9:48
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    //在调用方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //将Handler强转为HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        //获取方法上的Access注解
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            return true;
        }
        if (access.authorities().length > 0) {
            //如果权限配置不为空，则取出配置
            String[] authorities = access.authorities();
            Set<String> authSet = new HashSet<>();
            for (String authory : authorities) {
                //将权限加入一个set集合中
                authSet.add(authory);
            }
            //String role = httpServletRequest.getParameter("admin");
            String role = (String) httpServletRequest.getSession().getAttribute("role");
            System.out.println("ROLE 【】" + role);
            if (!RegExpUtil.isNull(role)) {
                if (authSet.contains(role)) {
                    return true;
                }
            }
        }


        return false;
    }

}
