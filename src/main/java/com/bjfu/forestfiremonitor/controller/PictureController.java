package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.PictureMapper;
import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.Video;
import com.bjfu.forestfiremonitor.service.MediaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class PictureController {

    @Autowired
    private MediaService mediaService;
    @Autowired
    PictureMapper pictureMapper;
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
    public String reloadpicturetable(String picturename,String type) throws JsonProcessingException {

        //fzj这先获取所有picture的list 然后遍历列表进行删除
        List<Picture> allpicture = mediaService.getAllPicture();

        if(!picturename.equals(""))
        {
            Picture temp;
            //遍历参照这个写 如果不符合条件就remove
            for (int i = allpicture.size() - 1; i >= 0; i--) {
                temp=allpicture.get(i);
                if ((temp.getImgname().toString()).indexOf(picturename)==-1) {
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
        String s=reqMap.get("imgid");
        //fzj这里把new一个picture然后放到session 起名字要保证别的地方用不到 sessionpictureToBeView
        //参照下边这个写
        Picture picture = new Picture();
        picture = mediaService.getPictureByID(Integer.parseInt(s));
        session.setAttribute("sessionPictureToBeView",picture);


        //其他不用做
        System.out.println(s);
        return "后台得到了id："+s;
    }

    @RequestMapping("/pictureDowland")
    public ResponseEntity<byte[]> fileDowland(HttpSession session) throws IOException {
        Picture picture=(Picture)session.getAttribute("sessionPictureToBeView");
        //指定下载文件
        String s=picture.getImgurl();
        String[] split=s.split("\\/");
        String ss=split[4];
        String prefix="/www/wwwroot/forestfiremonitor/resource/images";
        //
       // String prefix="C:\\Users\\wangz\\Desktop\\SEDesign\\forestfiremonitor\\src\\main\\resources\\static\\images\\";
        prefix+=ss;
        File file=new File(prefix);
        FileInputStream is = new FileInputStream(file);
        //通过字节数组保存文件
        byte[] body=new byte[is.available()];
        is.read(body);
        //获取文件名
        String name = file.getName();
        //转换文件名格式

        String dowlandFilename = new String(name.getBytes("UTF-8"),"ISO-8859-1");
        //设置文件头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename="+dowlandFilename);
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders,status);
        return responseEntity;

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


}
