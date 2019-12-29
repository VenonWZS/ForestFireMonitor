package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmrecordMapper {
    int deleteByPrimaryKey(Integer arecid);

    int insert(Alarmrecord record);

    int insertSelective(Alarmrecord record);

    List<Alarmrecord> selectAll();

    Alarmrecord selectByPrimaryKey(Integer arecid);

    List<Alarmrecord> selectByisConfirm(Integer isconfirm);

    int updateByPrimaryKeySelective(Alarmrecord record);

    int updateByPrimaryKey(Alarmrecord record);

    List<Alarmrecord> selectunhandeleds();
}