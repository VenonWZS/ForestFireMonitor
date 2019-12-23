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
            //System.out.println(splitdate[0]+" and "+splitdate[1]);
            if(targetYear.equals(splitdate[0])){
                byyear.add(alarmrecord);
            }

        }
        return byyear;
    }
    public HashMap<String, Integer> getCountByYear(int isConfirmFlag)
    {
        List<Alarmrecord> alarmrecords=alarmrecordMapper.selectAll();
        HashMap<String, Integer> countbyyear=new HashMap<String, Integer>();

        for(Alarmrecord alarmrecord : alarmrecords) {
            if (alarmrecord.getIsconfirm() == isConfirmFlag) {
                //得到年，月
                Date tempdate = alarmrecord.getAlarmtime();
                DateFormat fmt = new SimpleDateFormat("yyyy,MM");
                String processdate = fmt.format(tempdate);
                String[] splitdate = processdate.split(",");
                //System.out.println(splitdate[0] + " and " + splitdate[1]);

                if (countbyyear.containsKey(splitdate[0])) {
                    int value = countbyyear.get(splitdate[0]);
                    value++;
                    countbyyear.put(splitdate[0], value);
                } else {
                    int value = 1;
                    countbyyear.put(splitdate[0], value);
                }

            }
        }
        return countbyyear;
    }
    public HashMap<String,HashMap<String, Integer>> getCountByMonth(int isConfirmFlag)
    {
        List<Alarmrecord> alarmrecords=alarmrecordMapper.selectAll();
        HashMap<String,HashMap<String, Integer>> countMonthMap=new HashMap<>();
        HashMap<String, Integer> countbyyear=new HashMap<String, Integer>();
        //先遍历出年分和次数的hashmap
        for(Alarmrecord alarmrecord : alarmrecords) {
            if (alarmrecord.getIsconfirm() == isConfirmFlag) {
                //得到年，月
                Date tempdate = alarmrecord.getAlarmtime();
                DateFormat fmt = new SimpleDateFormat("yyyy,MM");
                String processdate = fmt.format(tempdate);
                String[] splitdate = processdate.split(",");
                //System.out.println(splitdate[0] + " and " + splitdate[1]);

                if (countbyyear.containsKey(splitdate[0])) {
                    int value = countbyyear.get(splitdate[0]);
                    value++;
                    countbyyear.put(splitdate[0], value);
                } else {
                    int value = 1;
                    countbyyear.put(splitdate[0], value);
                }
            }
        }


        for (String key : countbyyear.keySet()) {
            //遍历年次数表找到年
            //System.out.println("Key: " + key);
            HashMap<String, Integer> countbymonth=new HashMap<String, Integer>();//每一年的月份和次数的map
            for(Alarmrecord alarmrecord : alarmrecords) {
                if (alarmrecord.getIsconfirm() == isConfirmFlag) {
                    //得到年，月
                    Date tempdate = alarmrecord.getAlarmtime();
                    DateFormat fmt = new SimpleDateFormat("yyyy,MM");
                    String processdate = fmt.format(tempdate);
                    String[] splitdate = processdate.split(",");
                    //System.out.println(splitdate[0] + " and " + splitdate[1]);
                    if (key.equals(splitdate[0]))//年相等
                    {
                        if (countbymonth.containsKey(splitdate[1])) {
                            int value = countbymonth.get(splitdate[1]);
                            value++;
                            countbymonth.put(splitdate[1], value);
                        } else {
                            int value = 1;
                            countbymonth.put(splitdate[1], value);
                        }
                    }
                }
            }
            //到这就得到了这一年对应的months和次数关系map
            countMonthMap.put(key,countbymonth);

        }

        return countMonthMap;
    }
    public HashMap<String,HashMap<String, Integer>> getCountBySeason(int isConfirmFlag)
    {
        List<Alarmrecord> alarmrecords=alarmrecordMapper.selectAll();
        HashMap<String,HashMap<String, Integer>> countSeasonMap=new HashMap<>();
        HashMap<String, Integer> countbyyear=new HashMap<String, Integer>();
        //先遍历出年分和次数的hashmap
        for(Alarmrecord alarmrecord : alarmrecords) {
            if (alarmrecord.getIsconfirm() == isConfirmFlag) {
                //得到年，月
                Date tempdate = alarmrecord.getAlarmtime();
                DateFormat fmt = new SimpleDateFormat("yyyy,MM");
                String processdate = fmt.format(tempdate);
                String[] splitdate = processdate.split(",");
                //System.out.println(splitdate[0] + " and " + splitdate[1]);

                if (countbyyear.containsKey(splitdate[0])) {
                    int value = countbyyear.get(splitdate[0]);
                    value++;
                    countbyyear.put(splitdate[0], value);
                } else {
                    int value = 1;
                    countbyyear.put(splitdate[0], value);
                }
            }
        }


        for (String key : countbyyear.keySet()) {
            //遍历年次数表找到年
            //System.out.println("Key: " + key);
            HashMap<String, Integer> countbyseason=new HashMap<String, Integer>();//每一年的月份和次数的map
            for(Alarmrecord alarmrecord : alarmrecords) {
                //遍历alarm表
                if (alarmrecord.getIsconfirm() == isConfirmFlag) {
                    //得到年，月
                    Date tempdate = alarmrecord.getAlarmtime();
                    DateFormat fmt = new SimpleDateFormat("yyyy,MM");
                    String processdate = fmt.format(tempdate);
                    String[] splitdate = processdate.split(",");
                    //System.out.println(splitdate[0] + " and " + splitdate[1]);
                    if (key.equals(splitdate[0]))//年相等
                    {
                        if (splitdate[1].equals("01") || splitdate[1].equals("02") || splitdate[1].equals("03")) {
                            String mykey = "spring";
                            if (countbyseason.containsKey(mykey)) {
                                int value = countbyseason.get(mykey);
                                value++;
                                countbyseason.put(mykey, value);
                            } else {
                                int value = 1;
                                countbyseason.put(mykey, value);
                            }
                        }
                        else if (splitdate[1].equals("04") || splitdate[1].equals("05") || splitdate[1].equals("06")) {
                            String mykey = "summer";
                            if (countbyseason.containsKey(mykey)) {
                                int value = countbyseason.get(mykey);
                                value++;
                                countbyseason.put(mykey, value);
                            } else {
                                int value = 1;
                                countbyseason.put(mykey, value);
                            }
                        }
                        else if (splitdate[1].equals("07") || splitdate[1].equals("08") || splitdate[1].equals("09")) {
                            String mykey = "autum";
                            if (countbyseason.containsKey(mykey)) {
                                int value = countbyseason.get(mykey);
                                value++;
                                countbyseason.put(mykey, value);
                            } else {
                                int value = 1;
                                countbyseason.put(mykey, value);
                            }
                        }
                        else if (splitdate[1].equals("10") || splitdate[1].equals("11") || splitdate[1].equals("12")) {
                            String mykey = "winter";
                            if (countbyseason.containsKey(mykey)) {
                                int value = countbyseason.get(mykey);
                                value++;
                                countbyseason.put(mykey, value);
                            } else {
                                int value = 1;
                                countbyseason.put(mykey, value);
                            }
                        }
                    }
                }
            }
            //到这就得到了这一年对应的months和次数关系map
            countSeasonMap.put(key,countbyseason);
        }

        return countSeasonMap;
    }

}
