package com.Gaokao.service;

import com.Gaokao.entity.CollegeInfo;
import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.entity.ExamScoreInfo;

import java.util.List;

public interface CollegePlanService {
    public List<CollegePlanInfo> getAllCollegePlan();
    public List getSuitCollegePlan(List<ExamScoreInfo> scoreList);
    public List getPlanByCollegeName(String collegeName);
    public List getAllPlan(List<ExamScoreInfo> scoreList,String collegeName,String type);
}
