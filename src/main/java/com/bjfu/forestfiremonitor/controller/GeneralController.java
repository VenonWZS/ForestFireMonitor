package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.POI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneralController {

    @GetMapping("/login")
    public String login()
    {
        return "login/login";
    }
    @GetMapping("/professorMainpage")
    public String professorMainpage(){return "ProfessorManagement/MainPage";}

    @GetMapping("/unconfirmed_alarm")
    public String unconfirmed_alarm(){return "ProfessorManagement/unconfirmed_alarm";}
    @GetMapping("/statisticMain")
    public String statisticMainpage(){return "ProfessorManagement/StatisticMain";}
    @GetMapping("/zshmain")
    public String zshpage() {return "ProfessorManagement/index";}
    @GetMapping("/zshshow")
    public String showzsh() {return "stasticShow";}
    @RequestMapping("/getlocation")
    public String getlocation(HttpSession session) {

//        List <POI> p = new ArrayList<>();
//        POI p1 = new POI();
//        POI p2 = new POI();
//        POI p3 = new POI();
//        p1.setPoipixx(39);
//        p1.setPoipixy(116);
////        p1.set
////
////        session.setAttribute();
        return "getlocation";
    }



}
