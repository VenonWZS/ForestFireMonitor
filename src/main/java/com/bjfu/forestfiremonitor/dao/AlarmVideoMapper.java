package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.AlarmVideoKey;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AlarmVideoMapper {
    int deleteByPrimaryKey(AlarmVideoKey key);

    int insert(AlarmVideoKey record);

    int insertSelective(AlarmVideoKey record);

    List<Integer> selectbyarecid (int arecid);
}