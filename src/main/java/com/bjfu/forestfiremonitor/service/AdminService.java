package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.UserMapper;
import com.bjfu.forestfiremonitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService {
    @Autowired
    UserMapper userMapper;
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

}
