package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Log;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.bjfu.forestfiremonitor.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LogController{
    @Autowired
    AdminService adminManagementService;

    //用户表数据接口
    @RequestMapping(value = "/getlogdata")
    @ResponseBody
    public String logtabledatainit() throws JsonProcessingException {
        //fzj这获得所有用户的List
        List<Log> allLogs = adminManagementService.getAllLog();
        //其他不用做
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allLogs.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allLogs);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }

    @GetMapping(value = "/logtable")
    public String logtable()
    {
        return "logtable";
    }


}
