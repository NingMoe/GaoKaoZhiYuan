package com.Gaokao.controller;

import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
