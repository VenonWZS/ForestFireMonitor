package com.bjfu.forestfiremonitor.service;

import com.bjfu.forestfiremonitor.dao.UserMapper;
import com.bjfu.forestfiremonitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;


    public User getLogin(User user)
    {
        User u=userMapper.selectByPrimaryKey(user.getUserid());
        if(u==null)//为空
        {
            System.out.println("nullo");
            return null;
        }
        else//不为空
        {
            if(u.getUserpwd().equals(user.getUserpwd()))
            {
                System.out.println("passwordok");
                return u;
            }
            else {//密码错误
                System.out.println("passwordno");
                return null;
            }
        }
    }

    public void getRegister(User user)
    {

        user.setUserright(-1);
        userMapper.insert(user);
    }
}
