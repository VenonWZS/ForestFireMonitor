package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.AlarmrecordMapper;
import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatisticsService {
    @Autowired
    AlarmrecordMapper alarmrecordMapper;
    public List<Alarmrecord> getAlarmrecordByYear(String targetYear)
    {
        List<Alarmrecord> alarmrecords=alarmrecordMapper.selectAll();
        List<Alarmrecord> byyear=new ArrayList<Alarmrecord>();
        for(Alarmrecord alarmrecord : alarmrecords) {
            //得到年，月
            Date tempdate=alarmrecord.getAlarmtime();

            DateFormat fmt = new SimpleDateFormat("yyyy,MM");

            String processdate=fmt.format(tempdate);

            String[] splitdate=processdate.split(",");
            System.out.println(splitdate[0]+" and "+splitdate[1]);
            if(targetYear.equals(splitdate[0])){
                byyear.add(alarmrecord);
            }

        }
        return byyear;
    }
    public HashMap<String, Integer> getCountByYear()
    {
        List<Alarmrecord> alarmrecords=alarmrecordMapper.selectAll();
        HashMap<String, Integer> countbyyear=new HashMap<String, Integer>();

        for(Alarmrecord alarmrecord : alarmrecords) {
            //得到年，月
            Date tempdate=alarmrecord.getAlarmtime();
            DateFormat fmt = new SimpleDateFormat("yyyy,MM");
            String processdate=fmt.format(tempdate);
            String[] splitdate=processdate.split(",");
            System.out.println(splitdate[0]+" and "+splitdate[1]);

            if(countbyyear.containsKey(splitdate[0])) {
                int value = countbyyear.get(splitdate[0]);
                value++;
                countbyyear.put(splitdate[0],value);
            }
            else {
                int value=1;
                countbyyear.put(splitdate[0],value);
            }

        }
        return countbyyear;
    }


}
