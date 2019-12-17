package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.AlarmPictureKey;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmPictureMapper {
    int deleteByPrimaryKey(AlarmPictureKey key);

    int insert(AlarmPictureKey record);

    int insertSelective(AlarmPictureKey record);
}