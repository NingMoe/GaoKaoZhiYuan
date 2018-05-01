package com.Gaokao.controller;

import com.Gaokao.entity.*;
import com.Gaokao.service.CollegeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    //判断该用户已选择哪些志愿
    @RequestMapping("/getApplicatonByUid")
    @ResponseBody
    public String getApplicatonByUid(HttpSession session){
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        List<CollegeApplicationInfo> appList = collegeApplicationService.getApplicationByUid(user.getId());
        String appStr = "";
        if(appList!=null){
            for(CollegeApplicationInfo collegeApplicationInfo:appList){
                appStr = appStr+collegeApplicationInfo.getZsid()+",";
            }
        }
        return appStr;
    }
    @RequestMapping("/getApplicationAllByUid")
    @ResponseBody
    public Page getApplicationAllByUid(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                                       @RequestParam(value="name", defaultValue="")String name,
                                       @RequestParam(value="data", defaultValue="")String data,
                                       HttpSession session){
        Page pageInfo = new Page();
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        List<CollegeApplicationInfo> appList = collegeApplicationService.getApplicationAllByUid(user.getId());
        pageInfo.setRow(appList,pageNum);
        List appPageList=new ArrayList();
        for (int i = pageInfo.getBeginIndex();i<= pageInfo.getEndIndex();i++) {
            CollegeApplicationInfo app = (CollegeApplicationInfo) pageInfo.getRow().get(i);
            if(app!=null) {
                appPageList.add(app);
            }
        }
        pageInfo.setRow(appPageList);
        return pageInfo;
    }
    @RequestMapping("/updateApplicationRank")
    @ResponseBody
    public String updateApplicationRank(@RequestParam(value="zsid", defaultValue="-1")int zsid,
                                        @RequestParam(value="code", defaultValue="")String code,
                                        HttpSession session){
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        String msg = "";
        boolean flag = collegeApplicationService.updateApplicationRank(code,zsid,user.getId());
        if(flag)
            msg = "success";
        return msg;
    }
}
