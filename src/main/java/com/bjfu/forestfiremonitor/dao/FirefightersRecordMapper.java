package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.FirefightersRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirefightersRecordMapper {
    int deleteByPrimaryKey(@Param("arecid") Integer arecid, @Param("userid") String userid);

    int insert(FirefightersRecord record);

    int insertSelective(FirefightersRecord record);

    FirefightersRecord selectByPrimaryKey(@Param("arecid") Integer arecid, @Param("userid") String userid);

    List<FirefightersRecord> selectLocation(@Param("arecid") Integer arecid);

    int updateByPrimaryKeySelective(FirefightersRecord record);

    int updateByPrimaryKey(FirefightersRecord record);
}