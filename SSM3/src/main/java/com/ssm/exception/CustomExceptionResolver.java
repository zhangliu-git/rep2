package com.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张镠
 * @date 2019/7/23 - 18:26
 * 全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param e 系统抛出的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object handler, Exception e) {
        //handler就是处理器适配器要执行的handler（只有method）
        //解析出异常类型
        //若是系统自定义异常，直接抛出，在错误页面展示
//        String message = null;
//        if(e instanceof CustomException){
//            message = ((CustomException)e).getMessage();
//        }else {
//            //若不是系统自定义异常，则构造一个自定义异常类型
//            message = "未知错误";
//        }

        //上面改为
        CustomException customException = null;
        if(e instanceof CustomException){
            customException = (CustomException)e;
        }else {
            customException = new CustomException("未知错误");
        }
        String message = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        //指向错误页面
        modelAndView.setViewName("book/msg");
        return modelAndView;
    }
}

