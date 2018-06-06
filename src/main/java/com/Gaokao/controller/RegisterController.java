package com.Gaokao.controller;

import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.entity.ScoreVo;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserInfoService uService;

    @RequestMapping("/index")
    public  String registerIndex(){
        return "register";
    }
    @RequestMapping("/userRegister")
    public String userRegister(UserBaseInfo userBaseInfo, HttpServletRequest request, Model model,HttpSession httpSession){
        //别用成getAttribute
        int mathScore = Integer.parseInt(request.getParameter("mathScore"));
        int engScore =  Integer.parseInt(request.getParameter("engScore"));
        int cnScore = Integer.parseInt(request.getParameter("cnScore"));
        List<ExamScoreInfo> examScoreInfoList = new ArrayList<>();
        for(int i=1;i<=3;i++){
            String subject = "subSelect"+i;
            String score = "xkkmScore"+i;
            ExamScoreInfo examScoreInfo = new ExamScoreInfo();
            examScoreInfo.setScore(Integer.parseInt(request.getParameter(score)));
            examScoreInfo.setSubjectName(request.getParameter(subject));
            examScoreInfoList.add(examScoreInfo);
        }
        ExamScoreInfo mathScoreInfo = new ExamScoreInfo();
        mathScoreInfo.setScore(mathScore);
        mathScoreInfo.setSubjectName("数学");
        examScoreInfoList.add(mathScoreInfo);
        ExamScoreInfo engScoreInfo = new ExamScoreInfo();
        engScoreInfo.setScore(engScore);
        engScoreInfo.setSubjectName("英语");
        examScoreInfoList.add(engScoreInfo);
        ExamScoreInfo cnScoreInfo = new ExamScoreInfo();
        cnScoreInfo.setScore(cnScore);
        cnScoreInfo.setSubjectName("语文");
        examScoreInfoList.add(cnScoreInfo);
        UserBaseInfo user = uService.isUserLegal(userBaseInfo);
        if(user==null){
            userBaseInfo.setScoreList(examScoreInfoList);
           uService.addUser(userBaseInfo);
           List examList = uService.getExamScoreByUid(userBaseInfo.getId());
            userBaseInfo.setScoreList(examList);
           model.addAttribute("user",userBaseInfo);
           httpSession.setAttribute("user",userBaseInfo);
            return "common";
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
