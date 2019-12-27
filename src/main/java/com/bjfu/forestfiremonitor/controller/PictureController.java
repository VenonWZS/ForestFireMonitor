package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.Video;
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
import java.util.List;
import java.util.Map;

@Controller
public class PictureController {

    @Autowired
    private MediaService mediaService;

    //用户表数据接口
    @RequestMapping(value = "/getpicturedata")
    @ResponseBody
    public String picturetabledatainit() throws JsonProcessingException {
        //fzj这获得所有用户的List
        List<Picture> allpicture = mediaService.getAllPicture();
        //其他不用做
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allpicture.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allpicture);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;
    }
    //表格搜索的数据接口
    @RequestMapping("/reloadpicturetable")
    @ResponseBody
    public String reloadpicturetable(String picturename,String pictime,String type) throws JsonProcessingException {

        //fzj这先获取所有picture的list 然后遍历列表进行删除
        List<Picture> allpicture = mediaService.getAllPicture();

        if(!picturename.equals(""))
        {
            Picture temp;
            //遍历参照这个写 如果不符合条件就remove
            for (int i = allpicture.size() - 1; i >= 0; i--) {
                temp=allpicture.get(i);
                if (!(temp.getImgname().toString()).equals(picturename)) {
                    allpicture.remove(temp);
                }
            }
        }

        if(!pictime.equals(""))
        {
            Picture temp;
            for (int i = allpicture.size() - 1; i >= 0; i--) {
                temp=allpicture.get(i);
                if (!(temp.getCreatetime().toString()).equals(pictime)) {
                    allpicture.remove(temp);
                }
            }
        }

        if(!type.equals(""))
        {
            if(type.equals("0"))//监控视频
            {
                Picture temp;
                for (int i = allpicture.size() - 1; i >= 0; i--) {
                    temp=allpicture.get(i);
                    if (!(temp.getImgtype().equals(0))) {
                        allpicture.remove(temp);
                    }
                }
            }
            else if(type.equals("1"))//用户手动拍摄
            {

                Picture temp;
                for (int i = allpicture.size() - 1; i >= 0; i--) {
                    temp=allpicture.get(i);
                    if (!(temp.getImgtype().equals(1))) {
                        allpicture.remove(temp);
                    }
                }
            }
            else if(type.equals("2"))//报警视频
            {
                Picture temp;
                for (int i = allpicture.size() - 1; i >= 0; i--) {
                    temp=allpicture.get(i);
                    if (!(temp.getImgtype().equals(2))) {
                        allpicture.remove(temp);
                    }
                }
            }

        }
//其他不用做
        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allpicture.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allpicture);
        jsonString+=json;
        jsonString+="}";
        System.out.println(jsonString);
        return jsonString;
    }

    //按钮查看详情数据接口
    @RequestMapping(value = "/getpictureDetail")
    @ResponseBody
    public String getpictureDetail(@RequestParam Map<String,String> reqMap, HttpSession session){
        String s=reqMap.get("picid");
        //fzj这里把new一个picture然后放到session 起名字要保证别的地方用不到 sessionpictureToBeView
        //参照下边这个写
        Picture picture = new Picture();
        picture = mediaService.getPictureByID(Integer.parseInt(s));
        session.setAttribute("sessionPictureToBeView",picture);


        //其他不用做
        System.out.println(s);
        return "后台得到了id："+s;
    }

    @GetMapping("/picturetable")
    public String picturetable()
    {
        return "picturetable";
    }

    @GetMapping("/picturedetailpage")
    public String picturedetailpage()
    {
        return "picturedetailpage";
    }
    @GetMapping("/apppicturetable")
    public String apppicturetable(Model model)
    {
        List<Picture> picturelist = mediaService.getAllPicture();
        model.addAttribute(picturelist);
        return "apppicturetable";
    }

}
