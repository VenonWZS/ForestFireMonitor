package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}