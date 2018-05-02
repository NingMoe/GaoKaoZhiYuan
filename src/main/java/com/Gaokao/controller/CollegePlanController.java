package com.Gaokao.controller;

import com.Gaokao.entity.CollegePlanInfo;
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
            String ids="";
            String type="";
            JSONObject jsonObject = JSONObject.fromObject(data);
            type =  jsonObject.get("type")==null?"综合":(String)jsonObject.get("type");
            ids =  jsonObject.get("ids")==null?"":(String)jsonObject.get("ids");
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        List planInfoList;
        collegeName = '%'+collegeName+'%';
        Page pageInfo = new Page();
        planInfoList = collegePlanService.getAllPlan(user.getScoreList(),collegeName,type);

        pageInfo.setRow(planInfoList,pageNum);
        List planInfoPageList=new ArrayList();
        for (int i = pageInfo.getBeginIndex();i<= pageInfo.getEndIndex();i++) {
            CollegePlanInfo col = (CollegePlanInfo) pageInfo.getRow().get(i);
            if(col!=null) {
                planInfoPageList.add(col);
            }
        }
        pageInfo.setRow(planInfoPageList);
        return pageInfo;
    }
}
