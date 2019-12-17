package com.bjfu.forestfiremonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/login")
    public String login()
    {
        return "login/login";
    }
    @GetMapping("/professorMainpage")
    public String professorMainpage(){return "ProfessorManagement/MainPage";}




























    @GetMapping("/statisticMain")
    public String statisticMainpage(){return "ProfessorManagement/StatisticMain";}





}
