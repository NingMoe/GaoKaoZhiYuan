package com.gaokao.controller;

import com.gaokao.entity.UserBaseInfo;
import com.gaokao.service.CollegeInfoService;
import com.gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserInfoService uService;

    @Autowired
    private CollegeInfoService collegeInfoService;

    @RequestMapping("/index")
    public String userIndex(){
        return "userLogin";
    }

    @RequestMapping("/userlogin")
    public String userLogin(UserBaseInfo userBaseInfo, Model model,HttpSession httpSession){
        UserBaseInfo user = uService.isUserLegal(userBaseInfo);

        if(user!=null){
            httpSession.setAttribute("user",user);
            return "common";
        }
        else {
            return "error";
        }
    }


}
