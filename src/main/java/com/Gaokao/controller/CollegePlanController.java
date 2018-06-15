package com.Gaokao.controller;

import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.entity.Page;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.CollegePlanService;
import com.Gaokao.utils.ExeclUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

@Controller
@RequestMapping("/collegeplan")
public class CollegePlanController {

    @Autowired
    private CollegePlanService collegePlanService;

    @RequestMapping("/selectSuitCollegePlan")
    @ResponseBody
    public Page selectSuitCollegePlan(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                                 @RequestParam(value="name", defaultValue="")String collegeName,
                                 @RequestParam(value="data", defaultValue="")String data,
                                 HttpSession session,
                                 HttpServletResponse response){
        //json解析
            JSONObject jsonObject = JSONObject.fromObject(data);
        String type =  jsonObject.get("type")==null?"综合":(String)jsonObject.get("type");
        String areaStr =  jsonObject.get("area")==null?"全国":(String)jsonObject.get("area");
        String priorStr =  jsonObject.get("prior")==null?"专业优先":(String)jsonObject.get("prior");
        String majorName =  jsonObject.get("majorName")==null?"":(String)jsonObject.get("majorName");
        Integer execl = jsonObject.get("execl")==null? 0 :(Integer)jsonObject.get("execl");
        int prior = 0;
         if(priorStr.equals("院校优先")){
             prior = 1;
         }
         int area = 0;
         if(areaStr.equals("浙江省内")){
             area = 1;
         }
        if(areaStr.equals("浙江省外")){
             area = 2;
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
        planInfoList = collegePlanService.getAllSuitPlan(user.getScoreList(),collegeName,type,pageInfo.getPageSize(),startIndex,totalScore,majorName,prior,area);
        if(execl==1){
            getExcel(response,session,data,collegeName);
        }
        int total = 0;
        if(planInfoList!=null){
            if(!planInfoList.isEmpty()) {
                total = planInfoList.get(0).getTotalRecord();
            }
        }

        pageInfo.setRow(planInfoList,pageNum,total);
        return pageInfo;
    }

    @RequestMapping("/selectAllPlan")
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

        //数据库分页查询招生计划
        planInfoList = collegePlanService.getAllPlan(collegeName,type,pageInfo.getPageSize(),startIndex,majorName,prior);

        int total = 0;
        if(planInfoList!=null){
            if(!planInfoList.isEmpty()) {
                total = planInfoList.get(0).getTotalRecord();
            }
        }

        pageInfo.setRow(planInfoList,pageNum,total);
        return pageInfo;
    }

    @RequestMapping("/addPlanInfo")
    @ResponseBody
    public String addPlanInfo( @RequestParam(value="data", defaultValue="")String data){

        JSONArray json = JSONArray.fromObject(data);
        CollegePlanInfo collegePlanInfo = new CollegePlanInfo();
        Map planMap = new HashMap();
        if(json.size()>0){
            for(int i=0;i<json.size();i++){
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = json.getJSONObject(i);
                // 得到 每个对象中的属性值
                planMap.put(job.get("name"),job.get("value"));
            }
        }
        collegePlanInfo.setZsId(Integer.parseInt((String) planMap.get("zsId")));
        collegePlanInfo.setCollegeId((String) planMap.get("collegeId"));
        collegePlanInfo.setMajorId((String) planMap.get("majorId"));
        collegePlanInfo.setMajorName((String) planMap.get("majorName"));
        collegePlanInfo.setXkkm1((String) planMap.get("xkkm1"));
        collegePlanInfo.setXkkm2((String) planMap.get("xkkm2"));
        collegePlanInfo.setXkkm3((String) planMap.get("xkkm3"));
        collegePlanInfo.setScoreLine(Integer.parseInt((String) planMap.get("scoreLine")));
        collegePlanInfo.setNum(Integer.parseInt((String) planMap.get("num")));
        collegePlanInfo.setJhzsrs(Integer.parseInt((String) planMap.get("jhzsrs")));
        collegePlanInfo.setFlag(1);
        collegePlanInfo.setYear(2017);
        collegePlanService.addPlan(collegePlanInfo);
        return "success";
    }

    @RequestMapping("/deletePlan")
    @ResponseBody
    public String deletePlan(@RequestParam(value="id", defaultValue="1")int id){
        collegePlanService.deletePlan(id);
        return "success";
    }

    @RequestMapping("/recommendCollegePlan")
    @ResponseBody
    public Page recommendCollegePlan(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                                      @RequestParam(value="name", defaultValue="")String collegeName,
                                      @RequestParam(value="data", defaultValue="")String data,
                                      HttpSession session){
        //json解析
        JSONObject jsonObject = JSONObject.fromObject(data);
        String areaStr =  jsonObject.get("area")==null?"全国":(String)jsonObject.get("area");
        String type =  jsonObject.get("type")==null?"综合":(String)jsonObject.get("type");
        String priorStr =  jsonObject.get("prior")==null?"专业优先":(String)jsonObject.get("prior");
        String majorName =  jsonObject.get("majorName")==null?"":(String)jsonObject.get("majorName");
        String xkkm1 =  jsonObject.get("xkkm1")==null?"":(String)jsonObject.get("xkkm1");
        String xkkm2 =  jsonObject.get("xkkm2")==null?"":(String)jsonObject.get("xkkm2");
        String xkkm3 =  jsonObject.get("xkkm3")==null?"":(String)jsonObject.get("xkkm3");
        int xkkmScore1 =  jsonObject.get("xkkmScore1")==null?0:Integer.parseInt((String)jsonObject.get("xkkmScore1"));
        int xkkmScore2 =  jsonObject.get("xkkmScore1")==null?0:Integer.parseInt((String)jsonObject.get("xkkmScore1"));
        int xkkmScore3 =  jsonObject.get("xkkmScore1")==null?0:Integer.parseInt((String)jsonObject.get("xkkmScore1"));
        int mathScore =  jsonObject.get("mathScore")==null?0:Integer.parseInt((String)jsonObject.get("mathScore"));
        int engScore =  jsonObject.get("engScore")==null?0:Integer.parseInt((String)jsonObject.get("engScore"));
        int cnScore =  jsonObject.get("cnScore")==null?0:Integer.parseInt((String)jsonObject.get("cnScore"));
        int prior = 0;
        if(priorStr.equals("院校优先")){
            prior = 1;
        }
        int area = 0;
        if(areaStr.equals("浙江省内")){
            area = 1;
        }
        if(areaStr.equals("浙江省外")){
            area = 2;
        }
        List<CollegePlanInfo> planInfoList;
        collegeName = '%'+collegeName+'%';
        majorName = '%'+majorName+'%';
        Page pageInfo = new Page();
        int startIndex = (pageNum-1)*pageInfo.getPageSize();
        int totalScore=0;
        totalScore = xkkmScore1+xkkmScore2+xkkmScore3+mathScore+engScore+cnScore;
        //数据库分页查询招生计划
        planInfoList = collegePlanService.getSuitPlan(xkkm1,xkkm2,xkkm3,collegeName,type,pageInfo.getPageSize(),startIndex,totalScore,majorName,prior,area);

        int total = 0;
        if(planInfoList!=null){
            if(!planInfoList.isEmpty()) {
                total = planInfoList.get(0).getTotalRecord();
            }
        }

        pageInfo.setRow(planInfoList,pageNum,total);
        return pageInfo;
    }
    public void getExcel(HttpServletResponse response,HttpSession session,String data,String collegeName){
        //json解析
        JSONObject jsonObject = JSONObject.fromObject(data);
        String areaStr =  jsonObject.get("area")==null?"全国":(String)jsonObject.get("area");
        String type =  jsonObject.get("type")==null?"综合":(String)jsonObject.get("type");
        String priorStr =  jsonObject.get("prior")==null?"专业优先":(String)jsonObject.get("prior");
        String majorName =  jsonObject.get("majorName")==null?"":(String)jsonObject.get("majorName");
        UserBaseInfo user = (UserBaseInfo) session.getAttribute("user");
        int prior = 0;
        if(priorStr.equals("院校优先")){
            prior = 1;
        }
        int area = 0;
        if(areaStr.equals("浙江省内")){
            area = 1;
        }
        if(areaStr.equals("浙江省外")){
            area = 2;
        }
        int totalScore=0;
        for(ExamScoreInfo scoreItem :  user.getScoreList()){
            totalScore = totalScore+scoreItem.getScore();
        }
        majorName = '%'+majorName+'%';

        List<CollegePlanInfo> planInfoList = collegePlanService.getAllSuitPlan(user.getScoreList(),collegeName,type,80,0,totalScore,majorName,prior,area);
        ExeclUtils execlUtils = new ExeclUtils();
        String[][] dataList = execlUtils.getDataList(planInfoList);
        String sheetName = "高考志愿填报表单";
        String titleName = "高考志愿填报表";
        String fileName = "高考志愿填报表";
        int columnNumber = 5;
        int[] columnWidth = new int[5];
        for(int i = 0;i<5;i++){
            columnWidth[i]=30;
        }
        String[] columnName = { "高校编号", "高校名称", "专业编号","专业名称","地区" };
        try {
            execlUtils.ExportWithResponse(sheetName,titleName,fileName,columnNumber,columnWidth,columnName,dataList,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
