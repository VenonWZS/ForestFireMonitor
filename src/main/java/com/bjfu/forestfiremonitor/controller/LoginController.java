package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/getlogin")
    public String getlogin(User user, HttpSession session)
    {
        System.out.println("正在登陆ing11111。。。。。。");
        if(loginService.loginService(user))
        {
            session.setAttribute("sessionUser", user);
            return "login/loginok";
        }
        else
            return "login/loginfail";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login/login";
    }
}
