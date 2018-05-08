package com.Gaokao.service.impl;

import com.Gaokao.dao.CollegeInfoMapper;
import com.Gaokao.dao.CollegePlanMapper;
import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.service.CollegePlanService;
import org.apache.commons.lang.StringUtils;
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
    @Deprecated
    public List getSuitCollegePlan(List<ExamScoreInfo> scoreList) {
        //选考科目
        StringBuilder xkListSbu=new StringBuilder();
        List<CollegePlanInfo> planSuitList = new ArrayList<>();
        for(ExamScoreInfo score : scoreList){
            if(score.getSubjectId()>13) {
                xkListSbu=xkListSbu.append(score.getSubjectName()).append(",");
            }
        }
        String xkList = xkListSbu.toString();
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

    @Deprecated
    public List getSuitPlan(List<ExamScoreInfo> scoreList,List<CollegePlanInfo> planList) {
        //选考科目
        StringBuilder xkListSbu=new StringBuilder();
        List<CollegePlanInfo> planSuitList = new ArrayList<>();
        for(ExamScoreInfo score : scoreList){
            if(score.getSubjectId()>13) {
                xkListSbu=xkListSbu.append(score.getSubjectName()).append(",");
            }
        }
        String xkList = xkListSbu.toString();
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
    public List getAllSuitPlan(List<ExamScoreInfo> scoreList,String collegeName, String type,int pageSize,int offset,int totalScore,String majorName,int prior) {
       // List planList = collegePlanMapper.getAllPlan(collegeName,type);
       //List planSuitList = getSuitPlan(scoreList,planList);
        List<String> subject=new ArrayList();
        for(ExamScoreInfo score : scoreList){
            if(score.getSubjectId()>13) {
                subject.add(score.getSubjectName());
            }
        }
        String xkkm1 = StringUtils.isNotEmpty(subject.get(0))?subject.get(0):"";
        String xkkm2 = StringUtils.isNotEmpty(subject.get(1))?subject.get(1):"";
        String xkkm3 = StringUtils.isNotEmpty(subject.get(2))?subject.get(2):"";
        String bxkm = "不限";
        List planSuitList = collegePlanMapper.getAllSuitPlan(xkkm1,xkkm2,xkkm3,bxkm,collegeName,type,pageSize,offset,totalScore,majorName,prior);
       return planSuitList;
    }

    @Override
    public List getAllPlan(String collegeName, String type, int pageSize, int offset, String majorName, int prior) {
        return collegePlanMapper.getAllPlan(collegeName,majorName,type,prior,pageSize,offset);
    }

    @Override
    public void addPlan(CollegePlanInfo collegePlanInfo) {
        CollegePlanInfo cpInfo = collegePlanMapper.getPlanById(collegePlanInfo.getZsId());
        if(cpInfo==null){
            collegePlanMapper.addPlan(collegePlanInfo);

        }
    }

    @Override
    public void updatePlan(CollegePlanInfo collegePlanInfo) {
        collegePlanMapper.updatePlan(collegePlanInfo);
    }

    @Override
    public void deletePlan(int id) {
        collegePlanMapper.deletePlan(id);
    }
}
