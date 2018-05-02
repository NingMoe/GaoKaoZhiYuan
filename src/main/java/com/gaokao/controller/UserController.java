package com.gaokao.controller;

import com.gaokao.entity.UserBaseInfo;
import com.gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/changeInfo")
    public String changeInfo(String loginName, String passwd, HttpSession session){
        UserBaseInfo userBaseInfo = (UserBaseInfo) session.getAttribute("user");
        int id = userBaseInfo.getId();
        int flag = userInfoService.updateUserInfo(id,loginName,passwd);
        if(flag>0){
            userBaseInfo = userInfoService.getUserById(id);
        }
        session.setAttribute("user",userBaseInfo);
        return "changeInfo";
    }
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserBaseInfo getUserInfo(HttpSession session){
        UserBaseInfo userBaseInfo = (UserBaseInfo) session.getAttribute("user");
        return userBaseInfo;
    }
}
