package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LogMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    List<Log> getAllLog();

    void insertLog(String userclass,int userid,String logContent);
}