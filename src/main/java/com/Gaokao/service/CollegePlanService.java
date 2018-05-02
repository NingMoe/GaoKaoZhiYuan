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
     * @param type （高校类型排名）
     * @return
     */
    public List getAllPlan(List<ExamScoreInfo> scoreList,String collegeName,String type);
}
