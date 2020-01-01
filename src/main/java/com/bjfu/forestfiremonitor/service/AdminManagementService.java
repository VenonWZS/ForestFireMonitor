package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.LogMapper;
import com.bjfu.forestfiremonitor.dao.UserMapper;
import com.bjfu.forestfiremonitor.entity.Log;
import com.bjfu.forestfiremonitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AdminManagementService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LogMapper logMapper;

    public List<User> GetAllUser()
    {
        List<User> users;
        users= userMapper.selectAllUser();
        return users;
    }

    public void DeleteUserById(String userid)
    {
        userMapper.deleteByPrimaryKey(userid);
    }

    public void ChangeUserInfo(User user)
    {
        userMapper.updateByPrimaryKey(user);
    }

    public User getUserByName(String name)
    {
        User user = new User();
        user =userMapper.selectByUserName(name);
        return user;
    }

    public User getUserByID(String id)
    {
        User user = new User();
        user =userMapper.selectByUserName(id);
        return user;
    }

    public void insertLog (int usertype,String userid,String logcontent)
    {
        Log log = new Log();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String uploadtime = df.format(new Date());
        log.setLogclass(usertype);
        log.setLogcontent(logcontent);
        log.setLoguserid(userid);
        log.setLogtime(uploadtime);
        logMapper.insert(log);
    }

    public List<Log> getAllLog()
    {
        List <Log> alllog = new ArrayList<>();
        alllog = logMapper.getAllLog();
        return alllog;
    }

}
