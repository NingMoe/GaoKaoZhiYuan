package com.Gaokao.service;

import com.Gaokao.entity.CollegeInfo;
import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.entity.ExamScoreInfo;

import java.util.List;

public interface CollegePlanService {
    public List<CollegePlanInfo> getAllCollegePlan();
    //弃用
    public List getSuitCollegePlan(List<ExamScoreInfo> scoreList);
    //弃用
    public List getPlanByCollegeName(String collegeName);

    /**
     * 获得所有满足该考生选考科目的招生计划
     * @param scoreList （选考科目列表）
     * @param collegeName （高校名称）
     * @param pageSize （每页显示条数）
     * @param offset （起始）
     * @param totalScore （考生总成绩）
     * @param majorName （专业名称）
     * @param prior （院校优先or专业优先）
     * @return
     */
    public List getAllSuitPlan(List<ExamScoreInfo> scoreList,String collegeName,String type,int pageSize,int offset,int totalScore,String majorName,int prior);

    /**
     * 获得所有招生计划（不带入分数和选考科目）
     * @param collegeName
     * @param type
     * @param pageSize
     * @param offset
     * @param majorName
     * @param prior
     * @return
     */
    public List getAllPlan(String collegeName,String type,int pageSize,int offset,String majorName,int prior);

    public void addPlan(CollegePlanInfo collegePlanInfo);

    public void updatePlan(CollegePlanInfo collegePlanInfo);

    public void deletePlan(int id);
}
