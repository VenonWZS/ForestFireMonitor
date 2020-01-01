package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/getLogin")
    public String getlogin(User user,HttpSession session)
    {
        User u = loginService.getLogin(user);
        System.out.println("正在登陆ing11111。。。。。。");
        if(u != null)
        {
            if(u.getUserright()==-1)
            {
                //弹框提示没有权限
                return "/login";//返回登录页面
            }
            else if(u.getUserright()==0)
            {
                session.setAttribute("sessionUser", user);
                return "AdminManagement/indexadmin";
            }
            else if (u.getUserright()==1)
            {
                session.setAttribute("sessionUser", user);
                return "ProfessorManagement/indexprofessor";
            }
            else if(u.getUserright()==2){
                session.setAttribute("sessionUser", user);
                return "StaffUserManagement/indexstaff";
            }
            else if(u.getUserright()==3){
                session.setAttribute("sessionUser", user);
                //是否有第三类普通用户？
                return null;
            }
            return "ProfessorManagement/MainPage";
        }
        else
            //弹框提示登录信息错误
            return "login/loginfail";
    }

    @RequestMapping("/getRegister")
    public String getRegister(User user){
        loginService.getRegister(user);
        return "/login";
    }

    @RequestMapping("/oldindex")
    public String  oldindex(){
        return "oldindex";
    }


}
