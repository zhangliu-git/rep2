package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张镠
 * @date 2019/7/24 - 21:31
 * 测试拦截器
 */

public class HandlerInterceptor2 implements HandlerInterceptor {

    //进入handler方法之前执行
    //身份认证和身份授权
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //false表示拦截，true表示放行
        return true;
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
