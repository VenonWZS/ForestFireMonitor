package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.Monitor;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorMapper {
    int deleteByPrimaryKey(Integer mptid);

    int insert(Monitor record);

    int insertSelective(Monitor record);

    Monitor selectByPrimaryKey(Integer mptid);

    int updateByPrimaryKeySelective(Monitor record);

    int updateByPrimaryKey(Monitor record);
}