package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.service.AdminService;
import com.bjfu.forestfiremonitor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/adminMain")
    public String adminMain()
    {
        return "AdminManagement/AdminMain";
    }

    @RequestMapping("/adminGetAllUser")
    public String adminUserGetAllUser(HttpSession session)
    {
        List<User> users;
        users = adminService.GetAllUser();
        session.setAttribute("users",users);
        return "AdminManagement/search_user";
    }

    @RequestMapping("/adminUserDelete")
    public String adminUserDelete(User user,HttpSession session)
    {
        System.out.println(user.getUserid());
        adminService.DeleteUserById(user.getUserid());
        List<User> users;
        users = adminService.GetAllUser();
        session.setAttribute("users",users);
        return "AdminManagement/search_user";
    }


}
