package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.Video;
import com.bjfu.forestfiremonitor.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppGeneralController {
    @Autowired
    MediaService mediaService;
    @GetMapping("/applogin")
    public String login()
    {
        return "applogin";
    }
    @GetMapping("/appindex")
    public String appindex()
    {
        return "appindex";
    }
    @GetMapping("/apptodo")
    public String apptodo()
    {
        return "apptodo";
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
}
