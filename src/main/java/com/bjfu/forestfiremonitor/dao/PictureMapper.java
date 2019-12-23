package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer imgid);

    List<Picture> allPicture();

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

}