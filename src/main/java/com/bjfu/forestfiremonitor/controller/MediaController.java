package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.PictureMapper;
import com.bjfu.forestfiremonitor.dao.VideoMapper;
import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.Video;
import com.bjfu.forestfiremonitor.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    public String getAllVideo(HttpSession httpSession){
        List<Video> videoList = mediaService.getAllVideo();
        httpSession.setAttribute("videolist",videoList);
        return "ProfessorManagement/allvideo";
    }

    public String getAllPicture(HttpSession httpSession){
        List<Picture> pictureList = mediaService.getAllPicture();
        httpSession.setAttribute("picturelist",pictureList);
        return "ProfessorManagement/allpicture";
    }
    @Autowired
    VideoMapper videoMapper;
    @RequestMapping("/downloadVideo")
    public ResponseEntity<byte[]> downloadVideo(@RequestParam Map<String,String> reqMap, HttpSession session) throws IOException
    {
        String s=reqMap.get("vidid");
        String filelocation=videoMapper.selectByPrimaryKey(Integer.parseInt(s)).getVipurl();
        File file=new File(filelocation);
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

}
