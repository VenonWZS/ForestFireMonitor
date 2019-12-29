package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.entity.Video;
import com.bjfu.forestfiremonitor.service.LoginService;
import com.bjfu.forestfiremonitor.service.MediaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AppGeneralController {
    @Autowired
    MediaService mediaService;
    @Autowired
    LoginService loginService;
    @GetMapping("/applogin")
    public String login()
    {
        return "applogin";
    }
    @GetMapping("/appindex")
    public String appindex()
    {
        //fzj@@@@@@在这写获得所有1.发出警报的火情（isconfirm==1 and ishandled==-1）2.待确认火情个数（isconfirmed==0）3.已处理火情个数（ishandled==1）4.alarmrecordtable总火情个数
        //四个int
        return "appindex";
    }
    @GetMapping("/apptodo")
    public String apptodo()
    {
        //fzj@@@@@@在这写获得所有1.发出警报的火情（isconfirm==1 and ishandled==-1）2.待确认火情个数（isconfirmed==0）3.已处理火情个数（ishandled==1）4.alarmrecordtable总火情个数
        //四个int
        return "apptodo";

    }
    @GetMapping("/appacceptfire")
    public String appacceptfire()
    {
        //fzj@@@@@@在这获取所有的ishandeled==-1的alarmrecord 形式为List<alarmrecord>传到model里在appacceptfire.html里进行循环显示,前端框架已经搭好了
        return "appacceptfire";
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
        if(loginService.loginService(user))
        {
            session.setAttribute("sessionUser", user);
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
