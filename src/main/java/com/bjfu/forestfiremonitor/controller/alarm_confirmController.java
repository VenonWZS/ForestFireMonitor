package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.*;
import com.bjfu.forestfiremonitor.entity.*;
//import com.bjfu.forestfiremonitor.jiguang.JiGuangPushService;
//import com.bjfu.forestfiremonitor.jiguang.PushBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.sf.json.*;

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
    @GetMapping(value = "/alarmrecorddetailpage")
    public String alarmrecorddetailpage()
    {
        return "alarmrecorddetailpage";
    }

    @GetMapping(value = "/confirmedtabledetailedpage")
    public String confirmedtabledetailedpage()
    {
        return "confirmedtabledetailedpage";
    }
    @GetMapping(value = "/searchtabledetailedpage")
    public String searchtabledetailedpage()
    {
        return "searchtabledetailedpage";
    }
    @GetMapping(value = "/wrongdetailedpage")
    public String wrongdetailedpage()
    {
        return "wrongdetailedpage";
    }
    @GetMapping(value = "/missdetailedpage")
    public String missdetailedpage()
    {
        return "missdetailedpage";
    }



    @GetMapping(value = "/alarmedtable")
    public String alarmedtable()
    {
        return "alarmedtable";
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

    //正在推送火情的数据接口
    @RequestMapping(value = "/getalarmeddata")
    @ResponseBody
    public String alarmedtabledatainit() throws JsonProcessingException {
        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisHandled(-1);
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

    @Autowired
    AlarmVideoMapper alarmVideoMapper;
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    AlarmPictureMapper alarmPictureMapper;
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    FirefightersRecordMapper firefightersRecordMapper;
    @RequestMapping(value = "/gettableid")
    @ResponseBody
    public String gettableid(@RequestParam Map<String,String> reqMap, HttpSession session)
    {
        String s=reqMap.get("arecid");
        List<Integer> videolist=alarmVideoMapper.selectbyarecid(Integer.parseInt(s));
        Alarmrecord alarmrecord  = alarmrecordMapper.selectByPrimaryKey(Integer.parseInt(s));
        session.setAttribute("alarmselected",alarmrecord);
        List<Video> videos=new ArrayList<Video>();
        for(int one:videolist)
        {
            Video video=videoMapper.selectByPrimaryKey(one);
            videos.add(video);
        }
        session.setAttribute("RelatedVideos",videos);

        List<Integer> imglist=alarmPictureMapper.selectbyarecid(Integer.parseInt(s));
        List<Picture> pictures=new ArrayList<Picture>();
        for(int one:imglist)
        {
            Picture picture=pictureMapper.selectByPrimaryKey(one);
            pictures.add(picture);
        }

        session.setAttribute("RelatedPictures",pictures);

        //fzj这把RelatedVideos/RelatedPictures放到了session里 将跳转到/alarmrecorddetailpage 循环一下显示图片和视频 最上边显示这个alarmrecord的信息
        //测试的话去/oldindex左侧未确认火情点查看详情就跳转到这个页面 数据库里现在没有关联 需要去alarm_picture和alarm_video添加几个关联再查看
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
        //myc下边这句话报错
        alarmrecordMapper.updateByPrimaryKeySelective(alarmrecord);
        System.out.println(s);
        return "火情已确认，请刷新查看";
    }
    @RequestMapping(value = "/getConfirm2")
    @ResponseBody
    public  String getConfirm2(@RequestParam String s)
    {

        Alarmrecord alarmrecord=alarmrecordMapper.selectByPrimaryKey(Integer.parseInt(s));
        alarmrecord.setIsconfirm(1);
        //myc下边这句话报错
        alarmrecordMapper.updateByPrimaryKeySelective(alarmrecord);
        System.out.println(s);
        return "火情已确认，请刷新查看";
    }

    @Autowired
    private JiGuangPushService jiGuangPushService;
    //按钮推送火情数据接口
    @RequestMapping(value = "/getPush")
    @ResponseBody
    public  String getPush(@RequestParam Map<String,String> reqMap)
    {

        String s=reqMap.get("arecid");

        //myc获得了arecid，然后在这把对应报警信息的ishandled位置成-1
        Alarmrecord alarmrecord=alarmrecordMapper.selectByPrimaryKey(Integer.parseInt(s));
        alarmrecord.setIshandled(-1);
        alarmrecord.setIsconfirm(1);
        alarmrecordMapper.updateByPrimaryKeySelective(alarmrecord);


        //myc把火情的横纵坐标获得到下边两个string里
        String latitude=alarmrecord.getOptlattitude().toString();
        String longtitude=alarmrecord.getOptlongtitude().toString();

        //这里我写jpush推送到手机端
        PushBean pushBean = new PushBean();
        pushBean.setTitle("紧急！有新的火情！");
        String content="在纬度："+latitude+",经度："+longtitude+"发生了火灾！请尽快接警！";
        pushBean.setAlert(content);
        boolean flag = jiGuangPushService.pushAndroid(pushBean);
        System.out.println(flag);
        return "火情已经推送至APP！";
    }
    @RequestMapping(value = "/getLocationData")
    @ResponseBody
    public String getLocationData(@RequestParam Map<String,String> reqMap, HttpSession session)
    {
        String s=reqMap.get("arecid");
        Alarmrecord alarmrecord  = alarmrecordMapper.selectByPrimaryKey(Integer.parseInt(s));
        session.setAttribute("alarmselected",alarmrecord);
        session.setAttribute("arecid",s);

        //zsh这里获取了arecid 去firefighter表里查出来对应的记录 返回一个List<firefighterRecord> 设置到!!!!!!session里
        //在getlocation那个页面里从!!!!!!session获取一下（上网搜一下js里访问thymleaf）
        //显示真实的人员坐标
        return "后台得到了id："+s;
    }
    @RequestMapping(value = "/getlocation",produces = "text/html;charset=UTF-8")
    public String getlocation(HttpSession session,Model model) {
        String s = (String)session.getAttribute("arecid");
        List<FirefightersRecord> location = new ArrayList<>();
                location=firefightersRecordMapper.selectLocation(Integer.parseInt(s));
//        for(int i=0;i<location.size();i++)
//        {
//            System.out.println(location.get(i).getArecid());
//            System.out.println(location.get(i).getXlocation());
//            System.out.println(location.get(i).getYlocation());
//        }
        JSONArray js = JSONArray.fromObject(location);
        System.out.println(js);
        model.addAttribute("locations",js);
        return "getlocation";
    }
// @@@@@@@@@@@@@@@@@@@@表格内按钮事件接口结束@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


}
