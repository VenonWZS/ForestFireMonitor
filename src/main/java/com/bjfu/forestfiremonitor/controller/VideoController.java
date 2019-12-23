package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.entity.Video;
import com.bjfu.forestfiremonitor.service.MediaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {

    @Autowired
    private MediaService mediaService;

    //用户表数据接口
    @RequestMapping(value = "/getvideodata")
    @ResponseBody
    public String videotabledatainit() throws JsonProcessingException {
        //fzj这获得所有用户的List
        List<Video> allVideo = mediaService.getAllVideo();
        //其他不用做
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allVideo.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allVideo);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }
    //表格搜索的数据接口
    @RequestMapping("/reloadvideotable")
    @ResponseBody
    public String reloadvideotable(String videoname,String vidtime,String type) throws JsonProcessingException {

        //fzj这先获取所有video的list 然后遍历列表进行删除
        List<Video> allVideo = mediaService.getAllVideo();

        if(!videoname.equals(""))
        {
            Video temp;
            //遍历参照这个写 如果不符合条件就remove
            for (int i = allVideo.size() - 1; i >= 0; i--) {
                temp=allVideo.get(i);
                if (!(temp.getVidname().toString()).equals(videoname)) {
                    allVideo.remove(temp);
                }
            }
        }

        if(!vidtime.equals(""))
        {
            Video temp;
            for (int i = allVideo.size() - 1; i >= 0; i--) {
                temp=allVideo.get(i);
                if (!(temp.getVidstarttime().toString()).equals(vidtime)) {
                    allVideo.remove(temp);
                }
            }
        }

        if(!type.equals(""))
        {
            if(type.equals("0"))//监控视频
            {
                Video temp;
                for (int i = allVideo.size() - 1; i >= 0; i--) {
                    temp=allVideo.get(i);
                    if (!(temp.getVidtype().equals(0))) {
                        allVideo.remove(temp);
                    }
                }
            }
            else if(type.equals("1"))//用户手动拍摄
            {

                Video temp;
                for (int i = allVideo.size() - 1; i >= 0; i--) {
                    temp=allVideo.get(i);
                    if (!(temp.getVidtype().equals(1))) {
                        allVideo.remove(temp);
                    }
                }
            }
            else if(type.equals("2"))//报警视频
            {
                Video temp;
                for (int i = allVideo.size() - 1; i >= 0; i--) {
                    temp=allVideo.get(i);
                    if (!(temp.getVidtype().equals(2))) {
                        allVideo.remove(temp);
                    }
                }
            }

        }
//其他不用做
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allVideo.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allVideo);
        jsonString+=json;
        jsonString+="}";
        System.out.println(jsonString);
        return jsonString;
    }

    //按钮查看详情数据接口
    @RequestMapping(value = "/getVideoDetail")
    @ResponseBody
    public String getVideoDetail(@RequestParam Map<String,String> reqMap, HttpSession session){
        String s=reqMap.get("vidid");
        //fzj这里把new一个video然后放到session 起名字要保证别的地方用不到 sessionVideoToBeView
        //参照下边这个写
        Video video = new Video();
        video = mediaService.getVideoByID(Integer.parseInt(s));
        session.setAttribute("sessionVideoToBeView",video);


        //其他不用做
        System.out.println(s);
        return "后台得到了id："+s;
    }
    @GetMapping("/videotable")
    public String videotable()
    {
        return "videotable";
    }
}
