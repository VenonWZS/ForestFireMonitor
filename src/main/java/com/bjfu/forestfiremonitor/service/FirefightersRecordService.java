package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.FirefightersRecordMapper;
import com.bjfu.forestfiremonitor.entity.FirefightersRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirefightersRecordService {
    @Autowired
    FirefightersRecordMapper firefightersRecordMapper;

    public void insertFirefightersRecord(FirefightersRecord firefightersRecord){
        firefightersRecordMapper.insert(firefightersRecord);
    }
}
