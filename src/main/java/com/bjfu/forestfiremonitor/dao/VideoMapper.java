package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMapper {
    int deleteByPrimaryKey(Integer vidid);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer vidid);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}