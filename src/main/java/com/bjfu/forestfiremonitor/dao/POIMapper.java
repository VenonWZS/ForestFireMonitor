package com.bjfu.forestfiremonitor.dao;

import com.bjfu.forestfiremonitor.entity.POI;
import org.springframework.stereotype.Repository;

@Repository
public interface POIMapper {
    int deleteByPrimaryKey(Integer poiid);

    int insert(POI record);

    int insertSelective(POI record);

    POI selectByPrimaryKey(Integer poiid);

    int updateByPrimaryKeySelective(POI record);

    int updateByPrimaryKey(POI record);
}