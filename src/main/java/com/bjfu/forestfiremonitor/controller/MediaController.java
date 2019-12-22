package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.Video;
import com.bjfu.forestfiremonitor.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
}
