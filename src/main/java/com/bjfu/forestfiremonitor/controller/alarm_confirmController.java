package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.*;
import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.entity.Video;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class alarm_confirmController {
    @Autowired
    AlarmrecordMapper alarmrecordMapper;
    //马宇晨写的没用的。。。。。。
    @GetMapping(value = "/professorManagement/unconfirmed_alarm")
    public String list(Model model) {

        List<Alarmrecord> unconfirmedrecord = new ArrayList<>();
        unconfirmedrecord=alarmrecordMapper.selectByisConfirm(1);

        model.addAttribute("unconfirmed", unconfirmedrecord);

        return "ProfessorManagement/unconfirmed_alarm";
    }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@页面路径配置@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //全部火情页面路径配置
    @GetMapping(value = "/searchtable")
    public String prosearchTable(Model model) {

        return "searchtable";
    }
    //未确认火情页面路径配置
    @GetMapping(value = "/unconfirmtable")
    public String unconfirmtable()
    {
        return "unconfirmtable";
    }
    //已经确认火情页面路径配置
    @GetMapping(value = "/confirmedtable")
    public String confirmedtable()
    {
        return "confirmedtable";
    }
    //漏火情页面路径配置
    @GetMapping(value = "/misstable")
    public String missedtable()
    {
        return "misstable";
    }
    //错火情页面路径配置
    @GetMapping(value = "/wrongtable")
    public String wrongtable()
    {
        return "wrongtable";
    }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@页面路径配置结束@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


//@@@@@@@@@@@@@@@@@@@@初始化数据接口@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //全部火情的数据接口
    @RequestMapping(value = "/gettabledata")
    @ResponseBody
    public String tabledatainit() throws JsonProcessingException {
        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectAll();
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(alarmrecordList);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }

    //待确认火情的数据接口
    @RequestMapping(value = "/getunconfirmdata")
    @ResponseBody
    public String unconfirmtabledatainit() throws JsonProcessingException {
        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisConfirm(0);
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(alarmrecordList);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }

    //已确认火情的数据接口
    @RequestMapping(value = "/getconfirmdata")
    @ResponseBody
    public String confirmtabledatainit() throws JsonProcessingException {
        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisConfirm(1);
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(alarmrecordList);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }

    //漏上传火情的数据接口
    @RequestMapping(value = "/getmissdata")
    @ResponseBody
    public String misstabledatainit() throws JsonProcessingException {
        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisConfirm(-2);
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(alarmrecordList);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }

    //误上传火情的数据接口
    @RequestMapping(value = "/getwrongdata")
    @ResponseBody
    public String wrongtabledatainit() throws JsonProcessingException {
        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisConfirm(-1);
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(alarmrecordList);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }
//@@@@@@@@@@@@@@@@@@@@初始化数据接口结束@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//
//表格搜索的数据接口
@RequestMapping("/reloadtable")
@ResponseBody
public String bing(String uploaduserid,String isconfirm,String ishandle) throws JsonProcessingException {



    System.out.println(uploaduserid);
    System.out.println(isconfirm);
    System.out.println(ishandle);
    List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectAll();
    //进行转json处理


    if(!isconfirm.equals(""))
    {
        for (int i = alarmrecordList.size() - 1; i >= 0; i--) {
                Alarmrecord ar=alarmrecordList.get(i);
                if (!(ar.getIsconfirm().toString()).equals(isconfirm)) {
                    alarmrecordList.remove(ar);
                }
            }

    }
    if(!ishandle.equals(""))
    {
        for (int i = alarmrecordList.size() - 1; i >= 0; i--) {
            Alarmrecord ar=alarmrecordList.get(i);
            if (!(ar.getIshandled().toString()).equals(ishandle)) {
                alarmrecordList.remove(ar);
            }
        }
    }
    if(!uploaduserid.equals(""))
    {
        for (int i = alarmrecordList.size() - 1; i >= 0; i--) {
            Alarmrecord ar=alarmrecordList.get(i);
            if (!(ar.getUserid()).equals(uploaduserid)) {
                alarmrecordList.remove(ar);
            }
        }
    }


    String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+alarmrecordList.size()+",\"data\":";
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(alarmrecordList);
    jsonString+=json;
    jsonString+="}";
    //System.out.println(jsonString);
    return jsonString;

}

//

// @@@@@@@@@@@@@@@@@@@@表格内按钮事件接口@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //按钮查看详情数据接口myc
    @Autowired
    AlarmVideoMapper alarmVideoMapper;
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    AlarmPictureMapper alarmPictureMapper;
    @Autowired
    PictureMapper pictureMapper;
    @RequestMapping(value = "/gettableid")
    @ResponseBody
    public String gettableid(@RequestParam Map<String,String> reqMap, HttpSession session)
    {
        String s=reqMap.get("alecid");
        List<Integer> videolist=alarmVideoMapper.selectbyarecid(Integer.parseInt(s));
        List<Video> videos=new ArrayList<Video>();
        for(int one:videolist)
        {
            Video video=videoMapper.selectByPrimaryKey(one);
            videos.add(video);
        }
        session.setAttribute("videos",videos);

        List<Integer> imglist=alarmPictureMapper.selectbyarecid(Integer.parseInt(s));
        List<Picture> pictures=new ArrayList<Picture>();
        for(int one:imglist)
        {
            Picture picture=pictureMapper.selectByPrimaryKey(one);
            pictures.add(picture);
        }

        session.setAttribute("pictures",pictures);

//        AllResource allResource=new AllResource();
//        allResource.setId(Integer.parseInt(s));
//        allResource.setWriter(reqMap.get("writer"));
//        allResource.setType(reqMap.get("type"));
//        allResource.setUserid(reqMap.get("userid"));
//        allResource.setUploadtime(reqMap.get("uploadtime"));
//        allResource.setSummary(reqMap.get("summary"));
//        allResource.setLocation(reqMap.get("location"));
//        allResource.setSource(reqMap.get("source"));
//        allResource.setName(reqMap.get("name"));
//        allResource.setAreaname(reqMap.get("areaname"));
//
//        session.setAttribute("sessionDetailedAllResource",allResource);
        System.out.println(s);
        return "后台得到了id："+s;
    }
    //按钮确认火情数据接口
    @RequestMapping(value = "/getConfirm")
    @ResponseBody
    public  String getConfirm(@RequestParam Map<String,String> reqMap)
    {

        String s=reqMap.get("arecid");
        Alarmrecord alarmrecord=alarmrecordMapper.selectByPrimaryKey(Integer.parseInt(s));
        alarmrecord.setIsconfirm(1);
        alarmrecordMapper.updateByPrimaryKey(alarmrecord);
        System.out.println(s);
        return "上传成功，请刷新页面查看";
    }
// @@@@@@@@@@@@@@@@@@@@表格内按钮事件接口结束@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
}
