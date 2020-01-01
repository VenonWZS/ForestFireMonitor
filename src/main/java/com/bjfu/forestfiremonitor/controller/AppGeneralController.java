package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.AlarmrecordMapper;
import com.bjfu.forestfiremonitor.entity.*;
import com.bjfu.forestfiremonitor.service.FirefightersRecordService;
import com.bjfu.forestfiremonitor.service.LoginService;
import com.bjfu.forestfiremonitor.service.MediaService;
import com.bjfu.forestfiremonitor.service.StatisticsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class AppGeneralController {
    @Autowired
    MediaService mediaService;
    @Autowired
    LoginService loginService;
    @Autowired
    StatisticsService statisticsService;

    @Autowired
    FirefightersRecordService firefightersRecordService;

    @Autowired
    AlarmrecordMapper alarmrecordMapper;
    @GetMapping("/applogin")
    public String login()
    {
        return "applogin";
    }
    @GetMapping("/appindex")
    public String appindex(Model model)
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
            if(alarmrecord.getIsconfirm() == 1 && alarmrecord.getIshandled() == -1){
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
        //fzj@@@@@@在这写获得所有1.发出警报的火情（isconfirm==1 and ishandled==-1）2.待确认火情个数（isconfirmed==0）3.已处理火情个数（ishandled==1）4.alarmrecordtable总火情个数
        //四个int
        return "appindex";
    }


    @GetMapping("/apptodo")
    public String apptodo(Model model)
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
            if(alarmrecord.getIsconfirm() == 1 && alarmrecord.getIshandled() == -1){
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
        //fzj@@@@@@在这写获得所有1.发出警报的火情（isconfirm==1 and ishandled==-1）2.待确认火情个数（isconfirmed==0）3.已处理火情个数（ishandled==1）4.alarmrecordtable总火情个数
        //四个int
        return "apptodo";
    }
    @GetMapping(value = "/appacceptfire")
    public String appacceptfire(Model model)
    {
        List<Alarmrecord> unhandeleds = statisticsService.selectunhandeleds();

        model.addAttribute("unhandeleds",unhandeleds);
        //fzj@@@@@@在这获取所有的ishandeled==-1的alarmrecord 形式为List<alarmrecord>传到model里在appacceptfire.html里进行循环显示,前端框架已经搭好了
        return "appacceptfire";
    }
    @RequestMapping("/appacceptfiredetailpage")
    public String appacceptfiredetailpage(@RequestParam String arecid,Model model)
    {
        System.out.println(arecid);
        Alarmrecord alarmrecord= alarmrecordMapper.selectByPrimaryKey(Integer.parseInt(arecid));
        model.addAttribute("unhandeled",alarmrecord);
        return "appacceptfiredetailpage";

    }
    @RequestMapping("/doappacceptfire")
    @ResponseBody
    public String doappacceptfire(@RequestParam Map<String,String> reqMap, HttpSession httpSession)
    {
        for (String s : reqMap.keySet()) {
            System.out.println("key:" + s);

            System.out.println("values:" + reqMap.get(s));
        }

        String x=reqMap.get("x");
        String y=reqMap.get("y");
        String arecid=reqMap.get("arecid");

        User user = (User) httpSession.getAttribute("sessionUser");
        FirefightersRecord firefightersRecord= new FirefightersRecord();
        firefightersRecord.setArecid(Integer.parseInt(arecid));
        firefightersRecord.setUserid(user.getUserid());
        firefightersRecord.setXlocation(Double.parseDouble(x));
        firefightersRecord.setYlocation(Double.parseDouble(y));
        firefightersRecordService.insertFirefightersRecord(firefightersRecord);

//        newfzj到这就得到了经度和纬度
//        需要将arecid+用户id+经度+纬度写入firefiter表
//        从session获取userid

        return "recieve : x/y/arecid"+x+";"+y+";"+arecid;
    }
    @GetMapping("/appunconfirmtable")
    public String appunconfirmtable()
    {

        return "appunconfirmtable";
    }
    @GetMapping("/appsearchtable")
    public String appsearchtable()
    {

        return "appsearchtable";
    }
    @GetMapping("/apphandledtable")
    public String apphandledtable()
    {

        return "apphandledtable";
    }

    @GetMapping("/appvideotable")
    public String appvideotable(Model model)
    {
        List<Video> videolist = mediaService.getAllVideo();
        model.addAttribute(videolist);
        return "appvideotable";
    }
    @GetMapping("/apppicturetable")
    public String apppicturetable(Model model)
    {
        List<Picture> picturelist = mediaService.getAllPicture();
        model.addAttribute(picturelist);
        return "apppicturetable";
    }
    @GetMapping(value = "/appvideodetailpage")
    public String appvideodetailpage(Video video,Model model)
    {
        int id=video.getVidid();
        video=mediaService.getVideoByID(id);
        model.addAttribute("detailvideo",video);
        return "appvideodetailpage";
    }
    @GetMapping(value = "/apppicturedetailpage")
    public String apppicturedetailpage(Picture picture,Model model)
    {
        int id=picture.getImgid();
        picture=mediaService.getPictureByID(id);
        model.addAttribute("detailpicture",picture);
        return "apppicturedetailpage";
    }
    @RequestMapping("/getapplogin")
    @ResponseBody
    public String getapplogin(@RequestParam Map<String,String> reqMap, HttpSession session) throws JsonProcessingException {
        String username=reqMap.get("username");
        String password=reqMap.get("password");
        //zsh@@@@@@在这获得了username和password进行登录处理

        int ok=0;
        User user=new User();
        user.setUserid(username);
        user.setUserpwd(password);
        User uu = loginService.getLogin(user);
        if(uu!=null)
        {
            session.setAttribute("sessionUser", uu);
            ok=1;
        }


        //忽略之下的
        List<String> a=new ArrayList<>();
        a.add("aa");
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+ok+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(a);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;

    }
}
