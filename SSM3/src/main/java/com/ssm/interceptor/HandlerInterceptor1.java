package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张镠
 * @date 2019/7/24 - 21:31
 * 测试拦截器
 *  若多个拦截器都放行，则执行顺序：preHandle按顺序执行 ，postHandle afterCompletion按拦截器配置顺序反向执行
 *  若拦截1器放行，拦截2的preHandle才会执行，拦截2不放行，拦截2的postHandle afterCompletion不会执行（只要有一个不放行，postHandle不会执行）
 *
 *  小结：统一日志处理拦截器，preHandle一定要放行，所以要放在第一个
 *       登录认证拦截器，权限校验拦截器在其之后
 *
 */

public class HandlerInterceptor1 implements HandlerInterceptor {

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
