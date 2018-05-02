package com.Gaokao.controller;

import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserInfoService uService;

    @RequestMapping("/userRegister")
    public String userRegister(UserBaseInfo userBaseInfo, HttpServletRequest request, Model model){
        UserBaseInfo user = uService.isUserLegal(userBaseInfo);
        if(user==null){
           uService.addUser(userBaseInfo);
           model.addAttribute("user",userBaseInfo);
            return "userBaseInfo";
        }
        else {
            return "error";
        }
    }

    @RequestMapping("/check")
    @ResponseBody
    public String getUserByLoginName(String loginName){
        String flag="noRegister";
        if(uService.getUserByName(loginName)!=null){
            flag="hasRegister";
        }
        return flag;
    }
}
