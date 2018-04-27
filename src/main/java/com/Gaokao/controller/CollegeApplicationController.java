package com.Gaokao.controller;

import com.Gaokao.entity.CollegeApplicationInfo;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.CollegeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *志愿controller
 */
@Controller
@RequestMapping("/application")
public class CollegeApplicationController {
    @Autowired
    private CollegeApplicationService collegeApplicationService;

    @RequestMapping("/addApplication")
    @ResponseBody
    public String addApplication(@RequestParam(value="zsid", defaultValue="-1")int zsid, HttpSession session){
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        String msg = "";
        boolean flag = collegeApplicationService.addApplication(zsid,user.getId());
        if(flag)
         msg = "success";
        return msg;
    }
    @RequestMapping("/deleteApplication")
    @ResponseBody
    public String deleteApplication(@RequestParam(value="zsid", defaultValue="-1")int zsid, HttpSession session){
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        String msg = "";
        boolean flag = collegeApplicationService.deleteApplication(zsid,user.getId());
        if(flag)
            msg = "success";
        return msg;
    }
    @RequestMapping("/getApplicatonByUid")
    @ResponseBody
    public String getApplicatonByUid(HttpSession session){
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        List<CollegeApplicationInfo> appList = collegeApplicationService.getApplicatonByUid(user.getId());
        String appStr = "";
        if(appList!=null){
            for(CollegeApplicationInfo collegeApplicationInfo:appList){
                appStr = appStr+collegeApplicationInfo.getZsid()+",";
            }
        }
        return appStr;
    }
}
