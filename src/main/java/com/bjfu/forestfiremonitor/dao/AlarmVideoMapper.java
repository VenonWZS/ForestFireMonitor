package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.AlarmVideoKey;

public interface AlarmVideoMapper {
    int deleteByPrimaryKey(AlarmVideoKey key);

    int insert(AlarmVideoKey record);

    int insertSelective(AlarmVideoKey record);
}