package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.PictureMapper;
import com.bjfu.forestfiremonitor.dao.VideoMapper;
import com.bjfu.forestfiremonitor.entity.Picture;
import com.bjfu.forestfiremonitor.entity.Video;
import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    PictureMapper pictureMapper;

    public List<Video> getAllVideo(){
        return videoMapper.allVideo();
    }

    public List<Picture> getAllPicture(){
        return pictureMapper.allPicture();
    }

    public Video getVideoByID(Integer vidid){
        return videoMapper.selectByPrimaryKey(vidid);
    }



}
