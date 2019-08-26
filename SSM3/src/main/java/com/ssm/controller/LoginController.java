package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 张镠
 * @date 2019/7/24 - 22:04
 */
@Controller
public class LoginController {
    //登录
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) throws Exception{
        session.setAttribute("username",username);
        return "redirect:/book/queryItems.action";
    }
    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        session.invalidate();
        return "redirect:/book/queryItems.action";
    }
}
