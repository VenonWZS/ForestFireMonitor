package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmrecordMapper {
    int deleteByPrimaryKey(Integer arecid);

    int insert(Alarmrecord record);

    int insertSelective(Alarmrecord record);

    Alarmrecord selectByPrimaryKey(Integer arecid);

    int updateByPrimaryKeySelective(Alarmrecord record);

    int updateByPrimaryKey(Alarmrecord record);
}