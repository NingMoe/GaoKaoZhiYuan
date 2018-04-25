package com.Gaokao.service.impl;

import com.Gaokao.dao.CollegeInfoMapper;
import com.Gaokao.dao.CollegePlanMapper;
import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.service.CollegePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegePlanServiceImpl implements CollegePlanService {
    @Autowired
    private CollegePlanMapper collegePlanMapper;

    @Override
    public List<CollegePlanInfo> getAllCollegePlan() {
        return collegePlanMapper.getAllCollegePlan();
    }

    @Override
    public List getSuitCollegePlan(List<ExamScoreInfo> scoreList) {
        //选考科目
        String xkList="";
        List<CollegePlanInfo> planSuitList = new ArrayList<>();
        for(ExamScoreInfo score : scoreList){
            if(score.getSubjectId()>13) {
                xkList=xkList+score.getSubjectName()+",";
            }
        }
        List<CollegePlanInfo> planList = getAllCollegePlan();
        for(CollegePlanInfo planInfo : planList){
                String xkkm1 = planInfo.getXkkm1() == null ? "" : planInfo.getXkkm1();
                String xkkm2 = planInfo.getXkkm2() == null ? "" : planInfo.getXkkm2();
                String xkkm3 = planInfo.getXkkm3() == null ? "" : planInfo.getXkkm3();
                if (xkkm1.equals("不限") || (xkList.indexOf(xkkm1) >= 0 && xkList.indexOf(xkkm2) >= 0 && xkList.indexOf(xkkm3) >= 0)) {
                    planSuitList.add(planInfo);
                }
        }
        return planSuitList;
    }

    @Override
    public List getPlanByCollegeName(String collegeName) {
        return collegePlanMapper.getPlanByCollegeName(collegeName);
    }
    public List getSuitPlan(List<ExamScoreInfo> scoreList,List<CollegePlanInfo> planList) {
        //选考科目
        String xkList="";
        List<CollegePlanInfo> planSuitList = new ArrayList<>();
        for(ExamScoreInfo score : scoreList){
            if(score.getSubjectId()>13) {
                xkList=xkList+score.getSubjectName()+",";
            }
        }
        for(CollegePlanInfo planInfo : planList){
            String xkkm1 = planInfo.getXkkm1() == null ? "" : planInfo.getXkkm1();
            String xkkm2 = planInfo.getXkkm2() == null ? "" : planInfo.getXkkm2();
            String xkkm3 = planInfo.getXkkm3() == null ? "" : planInfo.getXkkm3();
            if (xkkm1.equals("不限") || (xkList.indexOf(xkkm1) >= 0 && xkList.indexOf(xkkm2) >= 0 && xkList.indexOf(xkkm3) >= 0)) {
                planSuitList.add(planInfo);
            }
        }
        return planSuitList;
    }
    @Override
    public List getAllPlan(List scoreList,String collegeName, String type) {
        List planList = collegePlanMapper.getAllPlan(collegeName,type);
       List planSuitList = getSuitPlan(scoreList,planList);
       return planSuitList;
    }
}
