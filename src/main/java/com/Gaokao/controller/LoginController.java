package com.Gaokao.controller;

import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.CollegeInfoService;
import com.Gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
