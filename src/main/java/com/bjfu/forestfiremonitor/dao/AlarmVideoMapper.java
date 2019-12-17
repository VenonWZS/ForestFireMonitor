package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.AlarmVideoKey;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmVideoMapper {
    int deleteByPrimaryKey(AlarmVideoKey key);

    int insert(AlarmVideoKey record);

    int insertSelective(AlarmVideoKey record);
}