package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.UserMapper;
import com.bjfu.forestfiremonitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;
    public boolean loginService(User user)
    {
        String userid=user.getUserid();
        User u=userMapper.selectByPrimaryKey(userid);
        if(u==null)
        {
            System.out.println("nullo");
            return false;
        }
        else
        {
            if(u.getUserpwd().equals(user.getUserpwd()))
            {
                System.out.println("passwordok");
                return true;
            }
            else {
                System.out.println("passwordno");
                return false;
            }
        }
    }
}
