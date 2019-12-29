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

        HashMap<String,Integer> countByYearMissMap=statisticsService.getCountByYear(0);
        HashMap<String,HashMap<String, Integer>> countByMonthMissMap=statisticsService.getCountByMonth(0);
        HashMap<String,HashMap<String, Integer>> countBySeasonMissMap=statisticsService.getCountBySeason(0);

        HashMap<String,Integer> countByYearDenyMap=statisticsService.getCountByYear(-1);
        HashMap<String,HashMap<String, Integer>> countByMonthDenyMap=statisticsService.getCountByMonth(-1);
        HashMap<String,HashMap<String, Integer>> countBySeasonDenyMap=statisticsService.getCountBySeason(-1);

        HashMap<String,Integer> countByYearConfirmMap=statisticsService.getCountByYear(1);
        HashMap<String,HashMap<String, Integer>> countByMonthConfirmMap=statisticsService.getCountByMonth(1);
        HashMap<String,HashMap<String, Integer>> countBySeasonConfirmMap=statisticsService.getCountBySeason(1);

        model.addAttribute("countbyyearmissmap",countByYearMissMap);
        model.addAttribute("countbymonthmissmap",countByMonthMissMap);
        model.addAttribute("countbyseasonmissmap",countBySeasonMissMap);

        model.addAttribute("countbyyeardenymap",countByYearDenyMap);
        model.addAttribute("countbymonthdenymap",countByMonthDenyMap);
        model.addAttribute("countbyseasondenymap",countBySeasonDenyMap);

        model.addAttribute("countbyyearconfirmmap",countByYearConfirmMap);
        model.addAttribute("countbymonthconfirmmap",countByMonthConfirmMap);
        model.addAttribute("countbyseasonconfirmmap",countBySeasonConfirmMap);
        return "ProfessorManagement/index";
//        return "ProfessorManagement/StatisticMain";
    }

    @GetMapping(value = "/showme")
    public String showzshStatistics(Model model){

        HashMap<String,Integer> countByYearMissMap=statisticsService.getCountByYear(0);
        HashMap<String,HashMap<String, Integer>> countByMonthMissMap=statisticsService.getCountByMonth(0);
        HashMap<String,HashMap<String, Integer>> countBySeasonMissMap=statisticsService.getCountBySeason(0);

        HashMap<String,Integer> countByYearDenyMap=statisticsService.getCountByYear(-1);
        HashMap<String,HashMap<String, Integer>> countByMonthDenyMap=statisticsService.getCountByMonth(-1);
        HashMap<String,HashMap<String, Integer>> countBySeasonDenyMap=statisticsService.getCountBySeason(-1);

        HashMap<String,Integer> countByYearConfirmMap=statisticsService.getCountByYear(1);
        HashMap<String,HashMap<String, Integer>> countByMonthConfirmMap=statisticsService.getCountByMonth(1);
        HashMap<String,HashMap<String, Integer>> countBySeasonConfirmMap=statisticsService.getCountBySeason(1);

        model.addAttribute("countbyyearmissmap",countByYearMissMap);
        model.addAttribute("countbymonthmissmap",countByMonthMissMap);
        model.addAttribute("countbyseasonmissmap",countBySeasonMissMap);

        model.addAttribute("countbyyeardenymap",countByYearDenyMap);
        model.addAttribute("countbymonthdenymap",countByMonthDenyMap);
        model.addAttribute("countbyseasondenymap",countBySeasonDenyMap);

        model.addAttribute("countbyyearconfirmmap",countByYearConfirmMap);
        model.addAttribute("countbymonthconfirmmap",countByMonthConfirmMap);
        model.addAttribute("countbyseasonconfirmmap",countBySeasonConfirmMap);

        return "ProfessorManagement/index";
    }

    @GetMapping("showmedata")
    public String ss (Model model)
    {
        HashMap<String,Integer> countByYearMissMap=statisticsService.getCountByYear(0);
        HashMap<String,HashMap<String, Integer>> countByMonthMissMap=statisticsService.getCountByMonth(0);
        HashMap<String,HashMap<String, Integer>> countBySeasonMissMap=statisticsService.getCountBySeason(0);

        HashMap<String,Integer> countByYearDenyMap=statisticsService.getCountByYear(-1);
        HashMap<String,HashMap<String, Integer>> countByMonthDenyMap=statisticsService.getCountByMonth(-1);
        HashMap<String,HashMap<String, Integer>> countBySeasonDenyMap=statisticsService.getCountBySeason(-1);

        HashMap<String,Integer> countByYearConfirmMap=statisticsService.getCountByYear(1);
        HashMap<String,HashMap<String, Integer>> countByMonthConfirmMap=statisticsService.getCountByMonth(1);
        HashMap<String,HashMap<String, Integer>> countBySeasonConfirmMap=statisticsService.getCountBySeason(1);

        model.addAttribute("countbyyearmissmap",countByYearMissMap);
        model.addAttribute("countbymonthmissmap",countByMonthMissMap);
        model.addAttribute("countbyseasonmissmap",countBySeasonMissMap);

        model.addAttribute("countbyyeardenymap",countByYearDenyMap);
        model.addAttribute("countbymonthdenymap",countByMonthDenyMap);
        model.addAttribute("countbyseasondenymap",countBySeasonDenyMap);

        model.addAttribute("countbyyearconfirmmap",countByYearConfirmMap);
        model.addAttribute("countbymonthconfirmmap",countByMonthConfirmMap);
        model.addAttribute("countbyseasonconfirmmap",countBySeasonConfirmMap);

        return "ProfessorManagement/StatisticMain";
    }
    @GetMapping(value = "/getByYearStatistics")
    public String getByYearStatistics(Model model){

        List<Alarmrecord> alarmrecordList=statisticsService.getAlarmrecordByYear("2018");

        model.addAttribute("uid","123");//

        return "ProfessorManagement/StatisticMain";
    }


    @GetMapping(value = "/statisticbyyear")
    public String statisticbyyear (Model model)
    {
        HashMap<String,Integer> countByYearMissMap=statisticsService.getCountByYear(0);
        HashMap<String,HashMap<String, Integer>> countByMonthMissMap=statisticsService.getCountByMonth(0);
        HashMap<String,HashMap<String, Integer>> countBySeasonMissMap=statisticsService.getCountBySeason(0);

        HashMap<String,Integer> countByYearDenyMap=statisticsService.getCountByYear(-1);
        HashMap<String,HashMap<String, Integer>> countByMonthDenyMap=statisticsService.getCountByMonth(-1);
        HashMap<String,HashMap<String, Integer>> countBySeasonDenyMap=statisticsService.getCountBySeason(-1);

        HashMap<String,Integer> countByYearConfirmMap=statisticsService.getCountByYear(1);
        HashMap<String,HashMap<String, Integer>> countByMonthConfirmMap=statisticsService.getCountByMonth(1);
        HashMap<String,HashMap<String, Integer>> countBySeasonConfirmMap=statisticsService.getCountBySeason(1);

        model.addAttribute("countbyyearmissmap",countByYearMissMap);
        model.addAttribute("countbymonthmissmap",countByMonthMissMap);
        model.addAttribute("countbyseasonmissmap",countBySeasonMissMap);

        model.addAttribute("countbyyeardenymap",countByYearDenyMap);
        model.addAttribute("countbymonthdenymap",countByMonthDenyMap);
        model.addAttribute("countbyseasondenymap",countBySeasonDenyMap);

        model.addAttribute("countbyyearconfirmmap",countByYearConfirmMap);
        model.addAttribute("countbymonthconfirmmap",countByMonthConfirmMap);
        model.addAttribute("countbyseasonconfirmmap",countBySeasonConfirmMap);
        return "statisticbyyear";
    }
    @GetMapping(value = "/statisticbyseason")
    public String statisticbyseason (Model model)
    { HashMap<String,Integer> countByYearMissMap=statisticsService.getCountByYear(0);
        HashMap<String,HashMap<String, Integer>> countByMonthMissMap=statisticsService.getCountByMonth(0);
        HashMap<String,HashMap<String, Integer>> countBySeasonMissMap=statisticsService.getCountBySeason(0);

        HashMap<String,Integer> countByYearDenyMap=statisticsService.getCountByYear(-1);
        HashMap<String,HashMap<String, Integer>> countByMonthDenyMap=statisticsService.getCountByMonth(-1);
        HashMap<String,HashMap<String, Integer>> countBySeasonDenyMap=statisticsService.getCountBySeason(-1);

        HashMap<String,Integer> countByYearConfirmMap=statisticsService.getCountByYear(1);
        HashMap<String,HashMap<String, Integer>> countByMonthConfirmMap=statisticsService.getCountByMonth(1);
        HashMap<String,HashMap<String, Integer>> countBySeasonConfirmMap=statisticsService.getCountBySeason(1);

        model.addAttribute("countbyyearmissmap",countByYearMissMap);
        model.addAttribute("countbymonthmissmap",countByMonthMissMap);
        model.addAttribute("countbyseasonmissmap",countBySeasonMissMap);

        model.addAttribute("countbyyeardenymap",countByYearDenyMap);
        model.addAttribute("countbymonthdenymap",countByMonthDenyMap);
        model.addAttribute("countbyseasondenymap",countBySeasonDenyMap);

        model.addAttribute("countbyyearconfirmmap",countByYearConfirmMap);
        model.addAttribute("countbymonthconfirmmap",countByMonthConfirmMap);
        model.addAttribute("countbyseasonconfirmmap",countBySeasonConfirmMap);

        return "statisticbyseason";
    }
    @GetMapping(value = "/statisticbymonth")
    public String statisticbymonth (Model model)
    {
        HashMap<String,Integer> countByYearMissMap=statisticsService.getCountByYear(0);
        HashMap<String,HashMap<String, Integer>> countByMonthMissMap=statisticsService.getCountByMonth(0);
        HashMap<String,HashMap<String, Integer>> countBySeasonMissMap=statisticsService.getCountBySeason(0);

        HashMap<String,Integer> countByYearDenyMap=statisticsService.getCountByYear(-1);
        HashMap<String,HashMap<String, Integer>> countByMonthDenyMap=statisticsService.getCountByMonth(-1);
        HashMap<String,HashMap<String, Integer>> countBySeasonDenyMap=statisticsService.getCountBySeason(-1);

        HashMap<String,Integer> countByYearConfirmMap=statisticsService.getCountByYear(1);
        HashMap<String,HashMap<String, Integer>> countByMonthConfirmMap=statisticsService.getCountByMonth(1);
        HashMap<String,HashMap<String, Integer>> countBySeasonConfirmMap=statisticsService.getCountBySeason(1);

        model.addAttribute("countbyyearmissmap",countByYearMissMap);
        model.addAttribute("countbymonthmissmap",countByMonthMissMap);
        model.addAttribute("countbyseasonmissmap",countBySeasonMissMap);

        model.addAttribute("countbyyeardenymap",countByYearDenyMap);
        model.addAttribute("countbymonthdenymap",countByMonthDenyMap);
        model.addAttribute("countbyseasondenymap",countBySeasonDenyMap);

        model.addAttribute("countbyyearconfirmmap",countByYearConfirmMap);
        model.addAttribute("countbymonthconfirmmap",countByMonthConfirmMap);
        model.addAttribute("countbyseasonconfirmmap",countBySeasonConfirmMap);
        return "statisticbymonth";
    }

}
