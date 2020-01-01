//package com.bjfu.forestfiremonitor.controller;
//
//import com.bjfu.forestfiremonitor.jiguang.JiGuangPushService;
//import com.bjfu.forestfiremonitor.jiguang.PushBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class JPushController {
//    @Autowired
//    private JiGuangPushService jiGuangPushService;
//    @GetMapping("/dopush")
//    public String getpush() {return "dopush";}
//    @RequestMapping(value = "/pushAll")
//    public String pushAll(@RequestParam String title, @RequestParam String content){
//        PushBean pushBean = new PushBean();
//
//        pushBean.setTitle(title);
//
//        pushBean.setAlert(content);
//        boolean flag = jiGuangPushService.pushAndroid(pushBean);
//        System.out.println(flag);
//        return "dopush";
//    }
//
//}
