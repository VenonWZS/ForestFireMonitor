package com.bjfu.forestfiremonitor.controller;

import com.bjfu.forestfiremonitor.dao.AlarmrecordMapper;
import com.bjfu.forestfiremonitor.dao.UserMapper;
import com.bjfu.forestfiremonitor.entity.Alarmrecord;
import com.bjfu.forestfiremonitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class alarm_confirmController {
    @Autowired
    AlarmrecordMapper alarmrecordMapper;
    @RequestMapping(value = "/professorManagement/unconfirmed_alarm", method = RequestMethod.GET)
    public String list(Model model) {

        List<Alarmrecord> unconfirmedrecord = new ArrayList<>();
        unconfirmedrecord=alarmrecordMapper.selectByisConfirm(1);

        model.addAttribute("unconfirmed", unconfirmedrecord);

        return "/professorManagement/unconfirmed_alarm";
    }
}
