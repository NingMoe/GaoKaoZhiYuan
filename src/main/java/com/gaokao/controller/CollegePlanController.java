package com.gaokao.controller;

import com.gaokao.entity.CollegePlanInfo;
import com.gaokao.entity.Page;
import com.gaokao.entity.UserBaseInfo;
import com.gaokao.service.CollegePlanService;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
            String ids="";
            String type="";
            JSONObject jsonObject = JSONObject.fromObject(data);
            type =  jsonObject.get("type")==null?"综合":(String)jsonObject.get("type");
            ids =  jsonObject.get("ids")==null?"":(String)jsonObject.get("ids");
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        List<CollegePlanInfo> planInfoList;
        collegeName = '%'+collegeName+'%';
        Page pageInfo = new Page();
        int startIndex = (pageNum-1)*pageInfo.getPageSize();
        //数据库分页
        planInfoList = collegePlanService.getAllPlan(user.getScoreList(),collegeName,type,pageInfo.getPageSize(),startIndex);

        int total = 0;
        if(planInfoList!=null){
            total = planInfoList.get(0).getTotalRecord();
        }

        pageInfo.setRow(planInfoList,pageNum,total);
        return pageInfo;
    }
}
