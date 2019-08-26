package com.ssm.controller;

import com.ssm.beans.BookCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 张镠
 * @date 2019/7/24 - 15:32
 * json交互测试
 */
@Controller
public class jsonTest {
    //请求是json，输出是json
    @RequestMapping("/requestJson")
    @ResponseBody
    //RequestBody将商品json串转为Java， ResponseBody将Java对象转为json串
    public BookCustom requestJson(@RequestBody BookCustom bookCustom){
        return bookCustom;
    }
    //请求是key/value，输出是json
    @RequestMapping("/responseJson")
    @ResponseBody
    //RequestBody将商品json串转为Java， ResponseBody将Java对象转为json串
    public  BookCustom responseJson(BookCustom bookCustom){
        return bookCustom;
    }
}
