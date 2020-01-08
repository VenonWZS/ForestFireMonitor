package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import com.bjfu.forestfiremonitor.entity.User;
import com.bjfu.forestfiremonitor.service.AdminService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminManagementController {

    @Autowired
    AdminService adminService;

    //用户表数据接口
    @RequestMapping(value = "/getuserdata")
    @ResponseBody
    public String usertabledatainit() throws JsonProcessingException {
        //List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectByisConfirm(1);

        //zsh这获得所有用户的List
        List <User> allUsers = adminService.GetAllUser();

        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+allUsers.size()+",\"data\":";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allUsers);
        jsonString+=json;
        jsonString+="}";
        //System.out.println(jsonString);
        return jsonString;

//        return null;
    }

    //表格搜索的数据接口
    @RequestMapping("/reloadusertable")
    @ResponseBody
    public String reloadusertable(String userid,String username) throws JsonProcessingException {


//        List<Alarmrecord> alarmrecordList= alarmrecordMapper.selectAll();
        User temp = new User();
        List<User> user= new ArrayList<>();
        user = adminService.GetAllUser();//获取全部list

        //zsh这先获取所有用户的list 然后遍历列表进行删除
        if(!username.equals(""))
        {
            for (int i = user.size() - 1; i >= 0; i--) {
                temp=user.get(i);
                if (!(temp.getUsername().toString()).equals(username)) {
                    user.remove(temp);
                }
            }
        }

        if(!userid.equals(""))
        {
            for (int i = user.size() - 1; i >= 0; i--) {
                temp=user.get(i);
                if (!(temp.getUserid().toString()).equals(userid)) {
                    user.remove(temp);
                }
            }
        }

        //进行转json处理
        String jsonString="{\"code\":0,\"message\":\"ok\", \"count\":"+user.size()+",\"data\":";


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        jsonString+=json;
        jsonString+="}";
        System.out.println(jsonString);
        return jsonString;

//        return null;

    }

    //按钮注销用户数据接口
    @RequestMapping(value = "/getDeleteUserConfirm")
    @ResponseBody
    public  String getDeleteUserConfirm(@RequestParam Map<String,String> reqMap)
    {
        String s=reqMap.get("userid");
        //按这种方式取user类里的属性
        //zsh进行删除操作
        adminService.DeleteUserById(s);

        System.out.println(s);
        return "注销用户成功，请刷新页面查看";
    }

    //按钮查看详情数据接口
    @RequestMapping(value = "/getChangeUser")
    @ResponseBody
    public String getChangeUser(@RequestParam Map<String,String> reqMap, HttpSession session){
        String s=reqMap.get("userid");
        //zsh这里把new一个user然后放到session 起名字要保证别的地方用不到 sessionUserToBeChange
        User user = new User();
        user=adminService.getUserByID(s);
        session.setAttribute("sessionUserToBeChange",user);
        //newzsh获取到了要修改信息的user了然后前端跳转到usermodifypage.html在那里写表单然后提交到后台(就在这个java里)进行用户的信息更新
        //其他不用做
        System.out.println(s);
        return "modifyok";
    }

    @GetMapping("/usermodifypage")
    public String userModifyPage()
    {
        return "usermodifypage";
    }

    @RequestMapping(value = "/getUserInfoChange")
    public String getUserInfoChange(HttpSession session, HttpServletRequest request)
    {
        User user = new User();
        user=(User)session.getAttribute("sessionUserToBeChange");
        String usermail = request.getParameter("usermail");
        String phone = request.getParameter("userphone");
        String userright = request.getParameter("userright");
        String userdept = request.getParameter("userdept");
        String emptime = request.getParameter("emptime");

        int right = Integer.parseInt(userright);

        user.setUserright(right);
        user.setUsermail(usermail);
        user.setEmptime(emptime);
        if(userdept!="") {
            user.setUserdept(userdept);
        }
        user.setUserphone(phone);
        adminService.ChangeUserInfo(user);
        //跳转页面
        return "usermodifypage";
    }
    @GetMapping("/adminpage")
    public String adminPage()
    {
        return "adminpage";
    }

}
