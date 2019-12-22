package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminManagementController {

    //用户表数据接口
    @RequestMapping(value = "/getuserdata")
    @ResponseBody
    public String usertabledatainit() throws JsonProcessingException {
        //List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisConfirm(1);

        //zsh这获得所有用户的List




        //进行转json处理
//        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(alarmrecordList);
//        jsonString+=json;
//        jsonString+="}";
//        //System.out.println(jsonString);
//        return jsonString;

        return null;
    }
    //表格搜索的数据接口
    @RequestMapping("/reloadusertable")
    @ResponseBody
    public String reloadusertable(String userid,String username) throws JsonProcessingException {


//        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectAll();

        //zsh这先获取所有用户的list 然后遍历列表进行删除
        if(!username.equals(""))
        {

        }

        if(!userid.equals(""))
        {

        }

        //进行转json处理
//        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";


//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(alarmrecordList);
//        jsonString+=json;
//        jsonString+="}";
        //System.out.println(jsonString);
//        return jsonString;

        return null;

    }

    //按钮注销用户数据接口
    @RequestMapping(value = "/getDeleteUserConfirm")
    @ResponseBody
    public  String getDeleteUserConfirm(@RequestParam Map<String,String> reqMap)
    {
        String s=reqMap.get("userid");
        //按这种方式取user类里的属性
        //zsh进行删除操作




        System.out.println(s);
        return "注销用户成功，请刷新页面查看";
    }

    //按钮查看详情数据接口
    @RequestMapping(value = "/getChangeUser")
    @ResponseBody
    public String getChangeUser(@RequestParam Map<String,String> reqMap, HttpSession session){
        String s=reqMap.get("userid");
        //zsh这里把new一个user然后放到session 起名字要保证别的地方用不到 sessionUserToBeChange

        //其他不用做
        System.out.println(s);
        return "后台得到了id："+s;
    }

    @GetMapping("/usermodifypage")
    public String userModifyPage()
    {
        return "usermodifypage";
    }

    @GetMapping("/adminpage")
    public String adminPage()
    {
        return "adminpage";
    }

}
