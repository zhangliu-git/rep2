package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 张镠
 * @date 2019/7/24 - 21:31
 * 登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {

    //进入handler方法之前执行
    //身份认证和身份授权
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //获取请求url
        String url = httpServletRequest.getRequestURI();
        //判断url是否是公开地址，实际要写入配置文件中
        if(url.indexOf("login.action")>=0){
            return true;
        }

        //判断session
        HttpSession session = httpServletRequest.getSession();
        //从session中获取用户信息
        String username = (String) session.getAttribute("username");
        if(username != null && !username.trim().isEmpty()){
            return true;
        }

        httpServletRequest.getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(httpServletRequest,httpServletResponse);
        //false表示拦截，true表示放行
        return false;
    }

    //进入handler方法之后，返回modelandview之前
    //从modelAndView出发，将公用的模型数据传入视图，也可以统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //执行handler方法之后执行
    //统一的异常处理，统一的日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

    }
}
