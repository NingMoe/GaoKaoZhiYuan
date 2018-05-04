package com.Gaokao.controller;

import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.entity.Page;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.CollegePlanService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/collegeplan")
public class CollegePlanController {

    @Autowired
    private CollegePlanService collegePlanService;

    @RequestMapping("/selectSuitCollegePlan")
    @ResponseBody
    public Page selectAllCollegePlan(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                                 @RequestParam(value="name", defaultValue="")String collegeName,
                                 @RequestParam(value="data", defaultValue="")String data,
                                 HttpSession session){
        //json解析
            JSONObject jsonObject = JSONObject.fromObject(data);
        String type =  jsonObject.get("type")==null?"综合":(String)jsonObject.get("type");
        String priorStr =  jsonObject.get("prior")==null?"专业优先":(String)jsonObject.get("prior");
        String majorName =  jsonObject.get("majorName")==null?"":(String)jsonObject.get("majorName");
        int prior = 0;
         if(priorStr.equals("院校优先")){
             prior = 1;
         }
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        List<CollegePlanInfo> planInfoList;
        collegeName = '%'+collegeName+'%';
        majorName = '%'+majorName+'%';
        Page pageInfo = new Page();
        int startIndex = (pageNum-1)*pageInfo.getPageSize();
        int totalScore=0;
        for(ExamScoreInfo scoreItem :  user.getScoreList()){
            totalScore = totalScore+scoreItem.getScore();
        }
        //数据库分页查询招生计划
        planInfoList = collegePlanService.getAllPlan(user.getScoreList(),collegeName,type,pageInfo.getPageSize(),startIndex,totalScore,majorName,prior);

        int total = 0;
        if(planInfoList!=null){
            if(!planInfoList.isEmpty()) {
                total = planInfoList.get(0).getTotalRecord();
            }
        }

        pageInfo.setRow(planInfoList,pageNum,total);
        return pageInfo;
    }
}
