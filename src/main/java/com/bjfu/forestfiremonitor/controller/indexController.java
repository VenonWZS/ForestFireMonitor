package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.UserMapper;
import com.bjfu.forestfiremonitor.entity.*;
import com.bjfu.forestfiremonitor.service.AdminManagementService;
import com.bjfu.forestfiremonitor.service.MediaService;
import com.bjfu.forestfiremonitor.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class indexController {

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    MediaService mediaService;

    @Autowired
    AdminManagementService adminManagementService;


    @GetMapping("/indexprofessorcontent")
    public String indexprofessorcontent(Model model)
    {
        List<Alarmrecord> alarmrecordList = statisticsService.selectAll();
        //所有火情个数
        int allAlarm = alarmrecordList.size();
        //发出警报的火情
        int soundAlarm = 0;
        //待确认火情个数
        int unconfirmed = 0;
        //已处理火情个数
        int handledAlarm = 0;
        for (Alarmrecord alarmrecord:alarmrecordList) {
            //alarmrecord.getIsconfirm() == 1 &&
            if( alarmrecord.getIshandled() == -1){
                soundAlarm++;
            }
            else if(alarmrecord.getIsconfirm() == 0){
                unconfirmed++;
            }
            else if(alarmrecord.getIshandled() == 1){
                handledAlarm++;
            }
        }

        model.addAttribute("allAlarm",allAlarm);
        model.addAttribute("soundAlarm",soundAlarm);
        model.addAttribute("unconfirmed",unconfirmed);
        model.addAttribute("handledAlarm",handledAlarm);

        List<Video> videoList=mediaService.getAllVideo();
        List<Picture> pictureList=mediaService.getAllPicture();

        model.addAttribute("videos",videoList);

        model.addAttribute("pictures",pictureList);

        List<User> users = mediaService.getAllUser();

        model.addAttribute("users",users);

        List<Log> allLogs = adminManagementService.getAllLog();
        model.addAttribute("indexLog",allLogs);

        return "indexprofessorcontent";
    }




    @GetMapping("/indexadmincontent")
    public String indexadmincontent(Model model)
    {
        List<Alarmrecord> alarmrecordList = statisticsService.selectAll();
        //所有火情个数
        int allAlarm = alarmrecordList.size();
        //发出警报的火情
        int soundAlarm = 0;
        //待确认火情个数
        int unconfirmed = 0;
        //已处理火情个数
        int handledAlarm = 0;
        for (Alarmrecord alarmrecord:alarmrecordList) {
            //alarmrecord.getIsconfirm() == 1 &&
            if( alarmrecord.getIshandled() == -1){
                soundAlarm++;
            }
            else if(alarmrecord.getIsconfirm() == 0){
                unconfirmed++;
            }
            else if(alarmrecord.getIshandled() == 1){
                handledAlarm++;
            }
        }

        model.addAttribute("allAlarm",allAlarm);
        model.addAttribute("soundAlarm",soundAlarm);
        model.addAttribute("unconfirmed",unconfirmed);
        model.addAttribute("handledAlarm",handledAlarm);

        List<Video> videoList=mediaService.getAllVideo();
        List<Picture> pictureList=mediaService.getAllPicture();

        model.addAttribute("videos",videoList);

        model.addAttribute("pictures",pictureList);

        List<User> users = mediaService.getAllUser();

        model.addAttribute("users",users);

        List<Log> allLogs = adminManagementService.getAllLog();
        model.addAttribute("indexLog",allLogs);

        return "indexadmincontent";
    }


    @GetMapping("/indexstaffcontent")
    public String indexstaffcontent(Model model)
    {
        List<Alarmrecord> alarmrecordList = statisticsService.selectAll();
        //所有火情个数
        int allAlarm = alarmrecordList.size();
        //发出警报的火情
        int soundAlarm = 0;
        //待确认火情个数
        int unconfirmed = 0;
        //已处理火情个数
        int handledAlarm = 0;
        for (Alarmrecord alarmrecord:alarmrecordList) {
            //alarmrecord.getIsconfirm() == 1 &&
            if( alarmrecord.getIshandled() == -1){
                soundAlarm++;
            }
            else if(alarmrecord.getIsconfirm() == 0){
                unconfirmed++;
            }
            else if(alarmrecord.getIshandled() == 1){
                handledAlarm++;
            }
        }

        model.addAttribute("allAlarm",allAlarm);
        model.addAttribute("soundAlarm",soundAlarm);
        model.addAttribute("unconfirmed",unconfirmed);
        model.addAttribute("handledAlarm",handledAlarm);

        List<Video> videoList=mediaService.getAllVideo();
        List<Picture> pictureList=mediaService.getAllPicture();

        model.addAttribute("videos",videoList);

        model.addAttribute("pictures",pictureList);

        List<User> users = mediaService.getAllUser();

        model.addAttribute("users",users);

        List<Log> allLogs = adminManagementService.getAllLog();
        model.addAttribute("indexLog",allLogs);

        return "indexstaffcontent";
    }

}
