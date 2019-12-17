package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.AlarmrecordMapper;
import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    AlarmrecordMapper alarmrecordMapper;
    public void sortByYear()
    {
        List<Alarmrecord> alarmrecords=alarmrecordMapper.selectAll();
        for(Alarmrecord alarmrecord : alarmrecords) {
            //得到年，月
            Date tempdate=alarmrecord.getAlarmtime();

            DateFormat fmt = new SimpleDateFormat("yyyy,MM");

            String processdate=fmt.format(tempdate);

            String[] splitdate=processdate.split(",");
            System.out.println(splitdate[0]+" and "+splitdate[1]);
        }

    }


}
