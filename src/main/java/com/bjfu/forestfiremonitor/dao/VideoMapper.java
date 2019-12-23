package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    int deleteByPrimaryKey(Integer vidid);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer vidid);

    List<Video> selectByName (String videoName);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> allVideo ();


}