package com.Gaokao.dao;

import com.Gaokao.entity.CollegePlanInfo;

import java.util.List;

public interface CollegePlanMapper {
    public List getAllCollegePlan();
    public List getPlanByCollegeName(String collegeName);
    public List getCollegeRankByType(String type);
    public List getAllPlan(String collegeName,String type);
    public CollegePlanInfo getPlanById(int zsid);
}
