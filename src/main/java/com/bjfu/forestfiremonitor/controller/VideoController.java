package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {
    //用户表数据接口
    @RequestMapping(value = "/getvideodata")
    @ResponseBody
    public String videotabledatainit() throws JsonProcessingException {
        //fzj这获得所有用户的List
        //List<Video> allVideo =
        //其他不用做
        //进行转json处理
//        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allVideo.size()+",\"data\":";
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(allVideo);
//        jsonString+=json;
//        jsonString+="}";
//        //System.out.println(jsonString);
//        return jsonString;

        return null;
    }
    //表格搜索的数据接口
    @RequestMapping("/reloadvideotable")
    @ResponseBody
    public String reloadvideotable(String videoname,String vidtime,String type) throws JsonProcessingException {


        //fzj这先获取所有video的list 然后遍历列表进行删除
        //List<Video> allVideo =

        if(!videoname.equals(""))
        {
            //遍历参照这个写 如果不符合条件就remove
//            for (int i = user.size() - 1; i >= 0; i--) {
//                temp=user.get(i);
//                if (!(temp.getUsername().toString()).equals(username)) {
//                    user.remove(temp);
//                }
//            }
        }

        if(!vidtime.equals(""))
        {
//            for (int i = user.size() - 1; i >= 0; i--) {
//                temp=user.get(i);
//                if (!(temp.getUserid().toString()).equals(userid)) {
//                    user.remove(temp);
//                }
//            }
        }

        if(!type.equals(""))
        {
            if(type.equals("0"))//监控视频
            {

            }
            else if(type.equals("1"))//用户手动拍摄
            {

            }
            else if(type.equals("2"))//报警视频
            {

            }

        }
//其他不用做
        //进行转json处理
//        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+user.size()+",\"data\":";
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(user);
//        jsonString+=json;
//        jsonString+="}";
//        System.out.println(jsonString);
//        return jsonString;

         return null;

    }

    //按钮查看详情数据接口
    @RequestMapping(value = "/getVideoDetail")
    @ResponseBody
    public String getVideoDetail(@RequestParam Map<String,String> reqMap, HttpSession session){
        String s=reqMap.get("userid");
        //fzj这里把new一个video然后放到session 起名字要保证别的地方用不到 sessionVideoToBeView
        //参照下边这个写
//        User user = new User();
//        user=adminService.getUserByID(s);
//        session.setAttribute("sessionUserToBeChange",user);
        //其他不用做
        System.out.println(s);
        return "后台得到了id："+s;
    }


}
