package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import com.bjfu.forestfiremonitor.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    @GetMapping(value = "/showStatistics")
    public String showStatistics(Model model){

        HashMap<String,Integer> countMap=statisticsService.getCountByYear();

        model.addAttribute("countmap",countMap);

        return "ProfessorManagement/StatisticMain";
    }
    @GetMapping(value = "/getByYearStatistics")
    public String getByYearStatistics(Model model){

        List<Alarmrecord> alarmrecordList=statisticsService.getAlarmrecordByYear("2018");

        model.addAttribute("uid","123");//

        return "ProfessorManagement/StatisticMain";
    }


}
