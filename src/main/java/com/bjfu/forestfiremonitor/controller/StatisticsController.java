package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    @GetMapping(value = "/getStatistics")
    public String showStatistics(){
        statisticsService.sortByYear();
        return "ProfessorManagement/StatisticMain";
    }

}
